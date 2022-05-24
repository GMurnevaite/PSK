package vu.psk1lab.usecases;


import lombok.Getter;
import lombok.Setter;
import vu.psk1lab.entities.Pilot;
import vu.psk1lab.interceptors.LoggedInvocation;
import vu.psk1lab.persistence.PilotDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdatePilotDetails implements Serializable {

    private Pilot pilot;

    @Inject
    private PilotDAO pilotDAO;

    @Inject
    private EntityManager em;


    @PostConstruct
    private void init(){
        System.out.println("------------UpdateAlbumDetails INIT CALLED------------");
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("pilotId"));
        this.pilot = pilotDAO.findOne(albumId);
    }

    @Transactional
    @LoggedInvocation
    public String updatePilotName(){
        try{
            pilotDAO.update(this.pilot);

        } catch (OptimisticLockException e){
            System.out.println(this.pilot.getPilot_id());
            return "/pilotDetails.xhtml?faces-redirect=true&pilotId=" + this.pilot.getPilot_id() + "&error=optimistic-lock-exception";
        }
        return "pilots.xhtml?airlineId=" + this.pilot.getAirlinesId().getAirline_id() + "&faces-redirect=true";
    }
}
