package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("ping")
public class PingResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        List<String> result = new ArrayList<>();
        result.add("A");
        result.add("B");
        
        return Response.ok(result).build();
    }
}
