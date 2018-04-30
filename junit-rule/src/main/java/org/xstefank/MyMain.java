package org.xstefank;

public class MyMain {

    public String sayHello(String name) {
        if (name.equals("paper")) {
            throw new IllegalArgumentException("Invalid argument");
        }
        return String.format("Hello %s!", name);
    }
}
