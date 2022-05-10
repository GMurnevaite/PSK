package vu.psk1lab.usecases;


import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.entities.Airline;
import vu.psk1lab.persistence.AirlineDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Airlines {


    @Inject
    private AirlineDAO airlineDAO;

    @Getter
    @Setter
    private Airline airlineToCreate = new Airline();

    @Getter
    private List<Airline> allAirlines;

    @PostConstruct
    public void init() { loadAllAirlines();}

    @Transactional
    public void createAirline(){ this.airlineDAO.persist(airlineToCreate);}

    private void loadAllAirlines(){
        this.allAirlines = airlineDAO.loadAll();
    }
}
