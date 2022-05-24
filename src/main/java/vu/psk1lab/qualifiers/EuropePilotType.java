package vu.psk1lab.qualifiers;

import javax.enterprise.context.Dependent;

@Europe
@Dependent
public class EuropePilotType implements PilotTypeProcessor{

    @Override
    public String PilotType() {
        return "The pilot flies only in europe";
    }
}