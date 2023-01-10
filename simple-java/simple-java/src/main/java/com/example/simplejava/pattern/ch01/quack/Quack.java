package com.example.simplejava.pattern.ch01.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꽥!");
    }
}
