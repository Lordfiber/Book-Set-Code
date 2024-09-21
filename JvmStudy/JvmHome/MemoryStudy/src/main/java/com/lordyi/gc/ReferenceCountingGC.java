package com.lordyi.gc;

public class ReferenceCountingGC {
    //-Xlog:gc*
    public Object instance = null;
    public static final int i=1024*1024;
    private byte[] byteArray=new byte[i];

    public static void test() {
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objB.instance = objA;
        objA.instance = objB;
        objA=null;
        objB=null;
        System.gc();
    }

    public static void main(String[] args) {
        test();
    }
}
