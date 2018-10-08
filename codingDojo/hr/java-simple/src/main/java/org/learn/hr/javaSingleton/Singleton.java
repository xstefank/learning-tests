package org.learn.hr.javaSingleton;

public class Singleton {

    private static final Singleton instance = new Singleton();
    
    private Singleton() {}
    
    public String str;
    
    public static Singleton getSingleInstance() {
        return instance;
    }
}
