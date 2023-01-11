package com.example.simplejava.pattern.ch01_strategy.quack;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("조용~");
    }
}
