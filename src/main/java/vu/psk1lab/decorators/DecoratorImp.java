package vu.psk1lab.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorImp implements AirlineDecorator{

    @Inject
    @Delegate @Any
    AirlineDecorator airlineDecorator;

    public Integer DecoratedInt(Integer integer){
        System.out.println("Decorator is used");
        return airlineDecorator.DecoratedInt(integer) * 10;
    }
}
