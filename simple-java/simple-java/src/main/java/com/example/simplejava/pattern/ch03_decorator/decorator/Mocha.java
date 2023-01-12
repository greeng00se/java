package com.example.simplejava.pattern.ch03_decorator.decorator;

import com.example.simplejava.pattern.ch03_decorator.beverage.Beverage;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }

    @Override
    public double cost() {
        return beverage.cost() + .2;
    }
}
