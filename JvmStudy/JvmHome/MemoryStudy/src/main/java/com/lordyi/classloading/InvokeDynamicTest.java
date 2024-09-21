package com.lordyi.classloading;

import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.lookup;

public class InvokeDynamicTest {
    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invoke("icyFenxi");
    }
    public static void testMethod(String s){
        System.out.println("hello :String" +s);
    }
    public static CallSite BoorStrapMethod(MethodHandles.Lookup lookup, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class,name,type));
    }

    public static MethodType MT_BootStrapMethod(){
        return MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class);    }
    private static MethodHandle MH_BootstrapMethod() throws Throwable
    {return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootStrapMethod());
    }
    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }
}
