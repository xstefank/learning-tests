package org.xstefank.lt;

import org.jboss.logging.Logger;

import javax.ws.rs.Encoded;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/encoded")
@Encoded
public class EncodedEndpoint {

    @POST
    @Path("/{param}")
    public void postEncoded(@PathParam("param") String param) {
        Logger.getLogger(EncodedEndpoint.class).info("received " + param);
    }

}
