package io.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;

public class AbstractBean {

    @Inject
    ProducerBean producerBean;
    
    public String test() {
        return producerBean.getHello() + " processed";
    }
}
