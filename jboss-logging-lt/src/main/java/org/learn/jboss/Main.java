package org.learn.jboss;

import org.jboss.logging.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("main-");
        Logger log = Logger.getLogger(Main.class);

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
