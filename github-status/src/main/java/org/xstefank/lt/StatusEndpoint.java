package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class StatusEndpoint {

    @GET
    @Path("/get")
    public String testGet() {
        return "Test GET invoked successfully";
    }
}
