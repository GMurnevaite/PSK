package vu.psk1lab.alternatives;

import javax.enterprise.context.Dependent;

@Dependent
public class AirlineMessage implements Message{

    @Override
    public String WriteMessage() {
        return "Pilot created";
    }

    public AirlineMessage(){
    }
}
