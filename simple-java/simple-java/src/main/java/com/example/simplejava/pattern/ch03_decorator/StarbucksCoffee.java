package com.example.simplejava.pattern.ch03_decorator;

import com.example.simplejava.pattern.ch03_decorator.beverage.Beverage;
import com.example.simplejava.pattern.ch03_decorator.beverage.Espresso;
import com.example.simplejava.pattern.ch03_decorator.beverage.HouseBlend;
import com.example.simplejava.pattern.ch03_decorator.beverage.Size;
import com.example.simplejava.pattern.ch03_decorator.decorator.Mocha;
import com.example.simplejava.pattern.ch03_decorator.decorator.Soy;
import com.example.simplejava.pattern.ch03_decorator.decorator.Whip;

public class StarbucksCoffee {

    public static void main(String[] args) {
        Beverage espresso = new Espresso(Size.TALL);
        printCost(espresso);

        Beverage houseBlend = new HouseBlend(Size.VENTI);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Whip(houseBlend);
        printCost(houseBlend);
    }

    private static void printCost(Beverage beverage) {
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
