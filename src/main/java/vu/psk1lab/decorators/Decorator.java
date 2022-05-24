package vu.psk1lab.decorators;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements AirlineDecorator{

    @Override
    public Integer DecoratedInt(Integer integer) {
        return integer;
    }

}
