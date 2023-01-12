package com.example.simplejava.pattern.ch03_decorator.beverage;

public class HouseBlend extends Beverage {

    public HouseBlend(Size size) {
        this.description = "하우스 블렌드 커피";
        this.size = size;
    }

    @Override
    public double cost() {
        return size.getCost() + .89;
    }
}
