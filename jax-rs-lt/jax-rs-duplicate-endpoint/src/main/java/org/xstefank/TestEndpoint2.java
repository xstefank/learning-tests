package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class TestEndpoint2 {

    @GET
    @Path("/one")
    public String testGet() {
        return "this is stub test 2";
    }
}
