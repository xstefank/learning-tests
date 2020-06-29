package io.xstefank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProducerBean {
    
    public String getHello() {
        return "produced hello";
    }
    
}
