package vu.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.mybatis.dao.AirlineMapper;
import vu.psk1lab.mybatis.dao.PilotMapper;
import vu.psk1lab.mybatis.model.Airline;
import vu.psk1lab.mybatis.model.Pilot;
import vu.psk1lab.qualifiers.Asia;
import vu.psk1lab.qualifiers.PilotTypeProcessor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class AirlinePilotsMyBatis {

    @Inject
    AirlineMapper airlineMapper;

    @Inject
    PilotMapper pilotMapper;

    @Inject @Asia
    PilotTypeProcessor pilotTypeProcessorAsia;

    @Getter
    @Setter
    private Airline airline;

    @Getter
    private List<Pilot> pilotList;

    @Getter @Setter
    private Pilot pilotToCreate = new Pilot();

    @PostConstruct
    public void init(){
        Map<String,String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer artistId = Integer.parseInt(requestParameters.get("airlineId"));

        this.airline = airlineMapper.selectByPrimaryKey(artistId);

    }

    public void loadAllAllPilots(){this.pilotList = pilotMapper.selectAll();}

    @Transactional
    public void createPilot(){
        pilotToCreate.setAirline(this.airline.getAirlineName());
        System.out.println(pilotTypeProcessorAsia.PilotType());
    }


}
