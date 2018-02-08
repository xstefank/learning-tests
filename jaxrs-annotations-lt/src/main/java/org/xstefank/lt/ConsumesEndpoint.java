package org.xstefank.lt;

import org.jboss.logging.Logger;
import org.xstefank.lt.model.DummyJson;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/consumes")
@Produces(MediaType.APPLICATION_JSON)
public class ConsumesEndpoint {

    @POST
    public void postJSON(DummyJson json) {
        Logger.getLogger(ConsumesEndpoint.class).info("received " + json.getName());
    }
}
