package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/redirect")
public class RedirectEndpoint {

    @GET
    @Path("/response")
    public String getResponse() {
        return "normal response";
    }

    @GET
    @Path("/dummy")
    public String getDummy() {
        return "DUMMY response";
    }
}
