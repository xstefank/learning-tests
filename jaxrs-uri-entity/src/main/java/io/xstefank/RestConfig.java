package io.xstefank;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        packages("io.xstefank");
    }
}
