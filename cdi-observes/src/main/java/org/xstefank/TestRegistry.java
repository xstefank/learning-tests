package org.xstefank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestRegistry {
    
    private final String value;


    public TestRegistry() {
        this.value = "asdfasdf";
    }

    public TestRegistry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
