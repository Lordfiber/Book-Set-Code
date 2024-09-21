package com.lordyi.gc;

public class TestAllocation {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws InterruptedException {
        byte [] allocation1=null,allocation2=null,allocation3=null,allocation4=null;
//        allocation1=new byte[2 * _1MB];
//        allocation2=new byte[2 * _1MB];
//        allocation3=new byte[2 * _1MB];
//        allocation4=new byte[4 * _1MB];
        Thread.sleep(5000);
        allocation1=getNewOne(allocation1);
        allocation2=getNewOne(allocation2);
        allocation3=getNewOne(allocation3);
        allocation4=getNewTwo(allocation4);
    }

    public static byte[] getNewOne(byte [] allocation){
        allocation=new byte[2*_1MB];
        return allocation;
    }
    public static byte[] getNewTwo(byte [] allocation){
        return new byte[4*_1MB];
    }
}
