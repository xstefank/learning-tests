package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class TestEndpoint {


    @GET
    @Path("/testEnv")
    public String getEnv() {
        return System.getenv("TEST_PROP") != null ? System.getenv("TEST_PROP") : "not found";
    }

    @GET
    @Path("/testProperty")
    public String getProperty() {
        return System.getProperty("TEST_PROP") != null ? System.getProperty("TEST_PROP") : "not found";
    }


}
