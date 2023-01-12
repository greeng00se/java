package com.example.simplejava.pattern.ch03_decorator.beverage;

public enum Size {
    TALL(0.5),
    GRANDE(1.0),
    VENTI(1.5);

    private final double cost;

    Size(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
