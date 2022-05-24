package vu.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.decorators.AirlineDecorator;
import vu.psk1lab.entities.Airline;
import vu.psk1lab.entities.Plane;
import vu.psk1lab.persistence.AirlineDAO;
import vu.psk1lab.persistence.PlaneDAO;

import javax.annotation.PostConstruct;
import javax.decorator.Delegate;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AirlinePlanes implements Serializable {

    @Inject
    private AirlineDecorator airlineDecorator;

    @Inject
    private PlaneDAO planesDAO;

    @Inject
    private AirlineDAO airlinesDAO;

    @Getter
    @Setter
    private Airline airline;

    @Getter @Setter
    private Plane planeToCreate = new Plane();

    @PostConstruct
    public void init(){
        Map<String,String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer artistId = Integer.parseInt(requestParameters.get("airlineId"));
        this.airline = airlinesDAO.findOne(artistId);
    }

    @Transactional
    public void createPlane(){
        planeToCreate.setAirline(this.airline);
        planesDAO.persist(planeToCreate);
        System.out.println("Decorator implementation: " + airlineDecorator.DecoratedInt(2));
    }
}
