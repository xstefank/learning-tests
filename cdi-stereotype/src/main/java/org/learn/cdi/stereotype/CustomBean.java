package org.learn.cdi.stereotype;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CustomBean {

    public String getHello(String name) {
        return "hello" + name;
    }
}
