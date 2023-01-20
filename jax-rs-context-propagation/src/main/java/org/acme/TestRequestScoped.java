package org.acme;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TestRequestScoped {

    public String getHello() {
        return "hello";
    }
}
