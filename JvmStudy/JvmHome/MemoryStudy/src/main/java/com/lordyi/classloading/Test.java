package com.lordyi.classloading;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.lang.invoke.MethodHandles.lookup;

public class Test {
    class GrandFather{
        void thinking(){
            System.out.println("I am GrandFather");
        }
    }

    class Father extends GrandFather{
        void thinking(){
            System.out.println("I am Father");
        }
    }

    class Son extends Father{
        /* void thinking(){
            try{
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh=lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());
                mh.invoke(this);//不加this会报错,需要显示的指出是哪一个实例在调用方法
            }catch (Throwable e){
                e.printStackTrace();
            }
        }*/
        void thinking(){
            try{
                MethodType mt = MethodType.methodType(void.class);
                Field lookupImpl=MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);
                MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null))
                        .findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            }catch (Throwable e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int x=5;
        ArrayList<Integer> list =new ArrayList<>();
        list.add(1);list.add(2);
        System.out.println(list);

    }
    public static void foo(ArrayList<Integer> list){
        for (Integer i : list) {
            i=5;
        }
    }
}
