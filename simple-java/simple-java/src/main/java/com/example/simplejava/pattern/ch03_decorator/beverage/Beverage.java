package com.example.simplejava.pattern.ch03_decorator.beverage;

public abstract class Beverage {
    String description = "제목 없음";
    Size size = Size.TALL;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
