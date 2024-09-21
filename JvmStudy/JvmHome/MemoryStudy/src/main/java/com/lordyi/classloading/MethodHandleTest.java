package com.lordyi.classloading;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable {
        Object obj=System.currentTimeMillis()%2==0 ? System.out:new ClassA();
        getPrintMh(obj).invokeExact("icyFenix");
    }
    private static MethodHandle getPrintMh(Object receiver) throws Throwable {
        MethodType mt=MethodType.methodType(void.class,String.class);
        return lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }
}
