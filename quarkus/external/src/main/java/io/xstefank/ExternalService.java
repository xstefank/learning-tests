package io.xstefank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExternalService {
    
    public String produce() {
        return "external";
    }
}
