package org.xstefank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Dummy {
    
    @TestAction
    public String getHello(String lraId) {
        return "Hello " + lraId;
    }
}
