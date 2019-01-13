package org.xstefank;

public class CustomDummy implements Dummy {
    @Override
    public String hello() {
        return "custom dummy";
    }
}
