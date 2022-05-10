package vu.psk1lab.persistence;

import vu.psk1lab.entities.Airline;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped

public class AirlineDAO {


    @Inject
    private EntityManager em;

    public List<Airline> loadAll() {return em.createNamedQuery("Airline.findAll", Airline.class).getResultList();}

    public void setEm(EntityManager em) {this.em = em;}

    public void persist(Airline airline) {this.em.persist(airline);}

    public Airline findOne(Integer airline_id) {return em.find(Airline.class, airline_id);}

}
