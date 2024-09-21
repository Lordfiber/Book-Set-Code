package com.lordyi.classloading;

public class TestClinit {
    public static int A=1;
    static{
        A=2;
    }
    static class Sub extends TestClinit{
        public static int B=A;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            {
                byte[] placeHolder=new byte[64*1024*1024];
            }
            int a=0;
            System.gc();
        }
    }
}
