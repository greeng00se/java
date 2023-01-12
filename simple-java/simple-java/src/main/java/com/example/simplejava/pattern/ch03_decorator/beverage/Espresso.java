package com.example.simplejava.pattern.ch03_decorator.beverage;

public class Espresso extends Beverage {

    public Espresso(Size size) {
        this.description = "에스프레소";
        this.size = size;
    }

    @Override
    public double cost() {
        return size.getCost() + 1.99;
    }
}
