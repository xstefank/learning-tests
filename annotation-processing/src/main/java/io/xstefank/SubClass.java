package io.xstefank;

public class SubClass extends TestSuperclass implements TestInterface {

    @Override
    public String myMethod() {
        return "subclass";
    }
}
