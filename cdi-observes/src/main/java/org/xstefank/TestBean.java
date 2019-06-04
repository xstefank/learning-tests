package org.xstefank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestBean {
    
    public String getHello() {
        return this.toString();
    }
}
