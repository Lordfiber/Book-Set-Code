package com.lordyi.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    public static List<HeapOOM> list;
    public static void main(String[] args) {
        list=new ArrayList<HeapOOM>();
        while(true){
            list.add(new HeapOOM());
        }
    }
}
