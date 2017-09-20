package org.learn.jboss;

import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class LogBean {

    @PostConstruct
    public static void postConstruct() {
        Logger log = Logger.getLogger(LogBean.class);

        log.info("Test info message");
        log.infof("Test infof message: %d", 42);
        log.infov("Test infov message: {0}", 42);


        try {
            new StackTraceCall().call();
        } catch (Exception e) {
            log.info("Caught exception", e);
        }
    }

}
