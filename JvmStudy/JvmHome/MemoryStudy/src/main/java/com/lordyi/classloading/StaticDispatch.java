package com.lordyi.classloading;

import java.util.Random;

public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
//        Human person= new Random().nextBoolean() ? new Man() : new Woman();
//        StaticDispatch sd = new StaticDispatch();
//        sd.sayHello((Man) person);
//        sd.sayHello((Woman) person);
    }
}
