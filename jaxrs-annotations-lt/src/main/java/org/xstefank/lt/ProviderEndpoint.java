package org.xstefank.lt;

import org.xstefank.lt.model.Dummy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/provider")
public class ProviderEndpoint {

    @GET
    public Dummy getDummy() {
        Dummy dummy = new Dummy();
        dummy.setName("Dummy");
        dummy.setAge(42);
        return dummy;
    }
}
