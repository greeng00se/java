package com.example.simplejava.pattern.ch03_decorator.decorator;

import com.example.simplejava.pattern.ch03_decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
