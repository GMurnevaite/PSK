package vu.psk1lab.usecases;

import lombok.Getter;
import vu.psk1lab.mybatis.dao.PilotMapper;
import vu.psk1lab.mybatis.dao.PlaneMapper;
import vu.psk1lab.mybatis.model.Pilot;
import vu.psk1lab.mybatis.model.Plane;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class PilotsPlanesMyBatis {

    @Inject
    PilotMapper pilotMapper;

    @Inject
    PlaneMapper planeMapper;


    @Getter
    private List<Pilot> pilotList;

    @Getter
    private List<Plane> planeList;

    @PostConstruct
    public void init(){this.loadAllPilotsPlanes();}

    private void loadAllPlanesPilots(){this.pilotList = planeMapper.selectPilotsForPlanes(1);}

    private void loadAllPilotsPlanes(){this.planeList = pilotMapper.selectPlanesForPilots(1);}

}
