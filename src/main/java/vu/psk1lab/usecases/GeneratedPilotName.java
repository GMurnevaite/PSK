package vu.psk1lab.usecases;

import vu.psk1lab.interceptors.LoggedInvocation;
import vu.psk1lab.services.PilotNameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GeneratedPilotName implements Serializable {

    @Inject
    PilotNameGenerator pilotNameGenerator;

    private CompletableFuture<String> pilotNameGenerationTask = null;

    @LoggedInvocation
    public String generateNewPilotName(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        pilotNameGenerationTask = CompletableFuture.supplyAsync(() -> pilotNameGenerator.generatePilotName());

        return "/pilotDetails.xhtml?faces-redirect=true&pilotId=" + requestParameters.get("pilotId");
    }

    public boolean isPilotNameGenerationRunning(){
        return pilotNameGenerationTask != null && !pilotNameGenerationTask.isDone();
    }

    public String getSongNumberGeneratorStatus() throws ExecutionException, InterruptedException {
        if (pilotNameGenerationTask == null) {
            return null;
        } else if (isPilotNameGenerationRunning()){
            return "Pilot name Generator in progress";
        }
        return "Suggested Pilot name: " + pilotNameGenerationTask.get();
    }
}
