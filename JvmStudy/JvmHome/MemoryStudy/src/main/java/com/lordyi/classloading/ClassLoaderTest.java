package com.lordyi.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 假设有以下项目结构：
 *
 * bash
 * 复制代码
 * /project
 *   /resources
 *     /com/example/MyClass.class
 *     /config/config.xml
 * 使用 getClass().getResourceAsStream("MyClass.class") 时，它会在 com/example/ 目录下查找 MyClass.class。
 * 使用 ClassLoader.getSystemResourceAsStream("com/example/MyClass.class") 时，它会从类路径根目录开始查找，因此必须提供完整路径 com/example/MyClass.class 才能找到资源。
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=ClassLoader.getSystemResourceAsStream(fileName);
                    if(is==null)
                        return super.loadClass(name);
                    byte [] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                   throw new ClassNotFoundException();
                }
            }
        };
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj=myLoader.loadClass("com.lordyi.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.lordyi.classloading.ClassLoaderTest);
    }
}
