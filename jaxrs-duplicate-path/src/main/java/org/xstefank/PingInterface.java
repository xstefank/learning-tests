package org.xstefank;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("interface")
public interface PingInterface {
    
    @Path("some")
    Response ping();
}
