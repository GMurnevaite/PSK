package vu.psk1lab.rest;

import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.entities.Airline;
import vu.psk1lab.entities.Pilot;
import vu.psk1lab.persistence.PilotDAO;
import vu.psk1lab.rest.contracts.PilotDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;
import java.net.URI;

@ApplicationScoped
@Path("/pilots")
public class PilotsController {

    @Inject
    @Setter @Getter
    private PilotDAO pilotDAO;

    @Getter @Setter
    private Airline airline;

    // http://localhost:8080/PSK1lab-1.0-SNAPSHOT/api/pilots/1
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){
        Pilot pilot = pilotDAO.findOne(id);

        if (pilot == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        PilotDto pilotDto = new PilotDto();
        pilotDto.setPilotName(pilot.getPilot_name());
        pilotDto.setAirlineName(pilot.getAirlinesId().getAirline_name());

        return Response.ok(pilotDto).build();
    }

    // http://localhost:8080/PSK1lab-1.0-SNAPSHOT/api/pilots/1
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer pilotId, PilotDto pilotDto){
        try {
            Pilot existingPilot = pilotDAO.findOne(pilotId);
            if (existingPilot == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPilot.setPilot_name(pilotDto.getPilotName());
            existingPilot.setAirline_name(pilotDto.getAirlineName());
            pilotDAO.update(existingPilot);
            return Response.ok().build();
        } catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
