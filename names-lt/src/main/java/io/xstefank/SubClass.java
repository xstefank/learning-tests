package io.xstefank;

public class SubClass extends SuperClass {
    
    public String getMyName() {
        return this.getClass().getName();
    }
}
