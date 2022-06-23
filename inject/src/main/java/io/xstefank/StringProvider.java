package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class StringProvider {

    @Produces
    public String hello() {
        return "hello";
    }

    @Produces
    public String differenthello() {
        return "different hello";
    }
}
