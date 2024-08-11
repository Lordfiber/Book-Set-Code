package com.lordyi.som;

public class JavaVMStackSOF {
    // VM Args： -Xss180k
    public int stackLength;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF stack = new JavaVMStackSOF();
        try{
            stack.stackLeak();
        }catch (Throwable e){
            System.out.println("stack lengthL"+stack.stackLength);
            throw e;
        }
    }
}
