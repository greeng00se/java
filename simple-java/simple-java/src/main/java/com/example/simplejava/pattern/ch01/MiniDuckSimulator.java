package com.example.simplejava.pattern.ch01;

import com.example.simplejava.pattern.ch01.fly.FlyWithWings;
import com.example.simplejava.pattern.ch01.quack.Quack;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        // Strategy Pattern
        Duck duck = new MallardDuck(new FlyWithWings(), new Quack());
        duck.performQuack();
        duck.performFly();
    }
}
