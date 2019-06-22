package io.xstefank;

import javax.ws.rs.Path;

@Path("test")
public class RootResource {

    @Path("not-annotated")
    public NotAnnotatedResource getRoot() {
        return new NotAnnotatedResource();
    }
}
