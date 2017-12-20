package org.learn.cdi.stereotype;

import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@TestStereotype
public class StereotypeBean {

    private static final Logger log = Logger.getLogger(StereotypeBean.class);

    @Inject
    private CustomBean customBean;

    @PostConstruct
    public void init() {
        log.infof("StereotypeBean init");
        log.info("saying hello " + customBean.getHello("Luke"));

    }

    public String getHello() {
        log.info("get hello");
        return customBean.getHello("Vader");
    }
}
