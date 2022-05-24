package vu.psk1lab.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class PilotNameGenerator implements Serializable {

    public String generatePilotName(){

        String[] names = {"Tomas","Jonas","Herkus", "Darius", "Linas", "Lukas"};

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
        }
        int random = new Random().nextInt(6);
        return names[random];
    }
}
