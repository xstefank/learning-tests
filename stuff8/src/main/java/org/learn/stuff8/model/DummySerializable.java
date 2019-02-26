package org.learn.stuff8.model;

import java.io.Serializable;

public class DummySerializable implements Serializable {

    private static final long serialVersionUID = 8703325234339436072L;
    
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
