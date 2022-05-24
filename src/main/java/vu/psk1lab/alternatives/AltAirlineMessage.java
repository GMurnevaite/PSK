package vu.psk1lab.alternatives;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative
public class AltAirlineMessage implements Message{
    @Override
    public String WriteMessage() {
        return "Alternative pilot created";
    }

    public AltAirlineMessage(){

    }
}
