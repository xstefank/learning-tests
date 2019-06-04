package io.xstefank.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestResource {
    
    @GET
    public String getHello() {
        return "hello";
    }
}
