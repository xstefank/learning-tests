package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class TestEndpoint1 {

    @GET
    @Path("/one")
    public String testGet() {
        return "this is stub test 1";
    }
}
