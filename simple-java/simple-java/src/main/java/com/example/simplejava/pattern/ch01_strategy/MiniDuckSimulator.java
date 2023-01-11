package com.example.simplejava.pattern.ch01_strategy;

import com.example.simplejava.pattern.ch01_strategy.fly.FlyWithWings;
import com.example.simplejava.pattern.ch01_strategy.quack.Quack;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        // Strategy Pattern
        Duck duck = new MallardDuck(new FlyWithWings(), new Quack());
        duck.performQuack();
        duck.performFly();
    }
}
