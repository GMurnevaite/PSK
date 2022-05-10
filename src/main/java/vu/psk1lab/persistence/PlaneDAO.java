package vu.psk1lab.persistence;


import vu.psk1lab.entities.Plane;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped

public class PlaneDAO {

    @Inject
    private EntityManager em;

    public List<Plane> loadAll() {
        return em.createNamedQuery("Plane.findAll", Plane.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Plane plane){
        this.em.persist(plane);
    }

    public Plane findOne(Integer plane_id) {
        return em.find(Plane.class, plane_id);
    }
}
