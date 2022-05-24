package vu.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.alternatives.Message;
import vu.psk1lab.entities.Airline;
import vu.psk1lab.entities.Pilot;
import vu.psk1lab.persistence.AirlineDAO;
import vu.psk1lab.persistence.PilotDAO;
import vu.psk1lab.qualifiers.Asia;
import vu.psk1lab.qualifiers.Europe;
import vu.psk1lab.qualifiers.EuropePilotType;
import vu.psk1lab.qualifiers.PilotTypeProcessor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class AirlinePilots implements Serializable {

    @Inject
    private AirlineDAO airlinesDAO;

    @Inject
    private PilotDAO pilotsDAO;

    @Inject
    private Message message;

    @Inject @Europe
    PilotTypeProcessor pilotTypeProcessor;

    @Inject @Any
    private EuropePilotType europePilotType;

    @Getter
    @Setter
    private Airline airline;

    @Getter @Setter
    private Pilot pilotToCreate = new Pilot();

    @Getter @Setter
    private List<Pilot> pilotsList;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer albumId = Integer.parseInt(requestParameters.get("airlineId"));
        this.airline = airlinesDAO.findOne(albumId);
    }

    @Transactional
    public void createPilot(){
        pilotToCreate.setAirlinesId(this.airline);
        pilotToCreate.setAirline_name(this.airline.getAirline_name());
        pilotsDAO.persist(pilotToCreate);
        System.out.println(message.WriteMessage());
        System.out.println(pilotTypeProcessor.PilotType());
        System.out.println(europePilotType.PilotType());
    }
}
