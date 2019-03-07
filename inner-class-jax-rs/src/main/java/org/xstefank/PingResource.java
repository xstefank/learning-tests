package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public abstract class PingResource {

    @Path("hello")
    public static class InnerResource1 {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String hello() {
            return "hello";
        }
    
    }

    @Path("hello2")
    public static class InnerResource2 {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String hello() {
            return "hello2";
        }

    }
}
