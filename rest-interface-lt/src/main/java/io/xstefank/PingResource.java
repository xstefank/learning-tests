package io.xstefank;

public class PingResource implements PingInterface {

    public String hello(String value) {
        return "hello " + value;
    }
}
