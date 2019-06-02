package io.xstefank;

import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.Principal;

@Path("/ping")
public class PingResource {

    @Inject
    Principal principal;
    
    @Inject
    JsonWebToken token;

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "principal " + principal.getName() + " groups: " + token.getGroups();
    }

    @GET
    @Path("dukes")
    @RolesAllowed("dukes")
    public String dukes() {
        return "principal " + principal.getName() + " groups: " + token.getGroups();
    }
}
