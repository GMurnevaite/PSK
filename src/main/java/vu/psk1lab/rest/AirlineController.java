package vu.psk1lab.rest;

import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.entities.Airline;
import vu.psk1lab.persistence.AirlineDAO;
import vu.psk1lab.rest.contracts.AirlineDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@ApplicationScoped
@Path("/airlines")
public class AirlineController {

    @Inject
    @Setter @Getter
    private AirlineDAO airlineDAO;

    @Inject
    private EntityManager em;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){

        Airline airline = airlineDAO.findOne(id);

        if (airline == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setAirlineName(airline.getAirline_name());


        return Response.ok(airlineDto).build();
    }

    // http://localhost:8080/PSK1lab-1.0-SNAPSHOT/api/airlines
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(AirlineDto airlineDto){

        try{
            if (airlineDto == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Airline airlineToCreate = new Airline();
            airlineToCreate.setAirline_name(airlineDto.getAirlineName());
            airlineDAO.persist(airlineToCreate);

            URI location = UriBuilder.fromResource(AirlineController.class)
                    .path("/{id}")
                    .resolveTemplate("id", airlineToCreate.getAirline_id())
                    .build();

            return Response.created(location).build();
        } catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
