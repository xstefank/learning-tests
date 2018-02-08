package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produces")
@Produces(MediaType.APPLICATION_JSON)
public class ProducesEndpoint {

    @GET
    public String getJSON() {
        return "{\"name\": \"testProduces\"}";
    }
}
