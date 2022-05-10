package vu.psk1lab.persistence;

import vu.psk1lab.entities.Pilot;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped

public class PilotDAO {

    @Inject
    private EntityManager em;

    public void persist(Pilot pilot) {this.em.persist(pilot);}

    public Pilot findOne(Integer pilot_id) {return em.find(Pilot.class, pilot_id);}

    public List<Pilot> findAll() {return em.createNamedQuery("Pilot.findAll",Pilot.class).getResultList();} //

    public Pilot update(Pilot pilot) {return  em.merge(pilot);}
}
