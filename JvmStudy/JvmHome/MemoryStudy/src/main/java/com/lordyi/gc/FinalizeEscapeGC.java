package com.lordyi.gc;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;
    public void isAlive(){
        System.out.println("HI,I am still alive");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize Method Executed");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
       SAVE_HOOK=new FinalizeEscapeGC();
       SAVE_HOOK=null;
       System.gc();
       Thread.sleep(500);
       if(SAVE_HOOK!=null){
           SAVE_HOOK.isAlive();
       } else{
           System.out.println("No,i am Dead");
       }

        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        } else{
            System.out.println("No,i am Dead");
        }
    }
}
