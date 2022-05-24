package vu.psk1lab.qualifiers;

import javax.enterprise.context.Dependent;

@Asia
@Dependent
public class AsiaPilotType implements PilotTypeProcessor{

    @Override
    public String PilotType() {
        return "The pilot flies only in asia";
    }

}
