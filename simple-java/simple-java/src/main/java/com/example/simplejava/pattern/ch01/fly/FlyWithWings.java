package com.example.simplejava.pattern.ch01.fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("나는 중~");
    }
}
