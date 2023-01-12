package com.example.simplejava.pattern.ch03_decorator.decorator;

import com.example.simplejava.pattern.ch03_decorator.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 두유";
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }
}
