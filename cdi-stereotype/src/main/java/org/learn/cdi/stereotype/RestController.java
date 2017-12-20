package org.learn.cdi.stereotype;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class RestController {

    @Inject
    private StereotypeBean stereotypeBean;

    @GET
    @Path("/test")
    public String test() {
        return stereotypeBean.getHello();
    }
}
