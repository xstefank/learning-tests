package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/same")
public class SameEndpoint2 {
    
    @GET
    @Path("/get")
    public String get() {
        return "SameEndpoint 2";
    }
}
