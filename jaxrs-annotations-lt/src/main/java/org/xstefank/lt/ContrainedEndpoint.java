package org.xstefank.lt;

import org.xstefank.lt.model.ConstrainedDummy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/constrained")
public class ContrainedEndpoint {

    @GET
    public ConstrainedDummy getDummy() {
        ConstrainedDummy dummy = new ConstrainedDummy();
        dummy.setName("Contrained class dummy");
        dummy.setAge(42);
        return dummy;
    }
}
