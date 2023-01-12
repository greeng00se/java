package com.example.simplejava.pattern.ch03_decorator.decorator;

import com.example.simplejava.pattern.ch03_decorator.beverage.Beverage;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 휘핑 크림";
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }
}
