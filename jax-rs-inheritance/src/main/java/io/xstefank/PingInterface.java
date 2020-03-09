package io.xstefank;

public interface PingInterface {

    @TestAnnotation("ping-interface")
    String hello() throws NoSuchMethodException;
}
