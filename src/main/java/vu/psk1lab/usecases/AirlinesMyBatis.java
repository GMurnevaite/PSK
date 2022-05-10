package vu.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.mybatis.dao.AirlineMapper;
import vu.psk1lab.mybatis.model.Airline;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AirlinesMyBatis {

    @Inject
    AirlineMapper airlineMapper;

    @Getter
    private List<Airline> airlinesList;

    @Getter @Setter
    private Airline airlinesToCreate = new Airline();

    @PostConstruct
    public void init(){this.loadAllAirlines();}

    private void loadAllAirlines(){
        this.airlinesList = airlineMapper.selectAll();
    }



    @Transactional
    public String createAirline(){
        airlineMapper.insert(airlinesToCreate);
        return "/myBatis/airlines?faces-redirect=true";
    }
}
