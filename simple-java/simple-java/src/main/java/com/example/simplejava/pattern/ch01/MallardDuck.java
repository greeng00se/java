package com.example.simplejava.pattern.ch01;

import com.example.simplejava.pattern.ch01.fly.FlyBehavior;
import com.example.simplejava.pattern.ch01.quack.QuackBehavior;

public class MallardDuck extends Duck {

    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("물오리 꽥!");
    }
}
