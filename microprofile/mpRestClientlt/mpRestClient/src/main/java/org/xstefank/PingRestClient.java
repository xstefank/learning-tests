package org.xstefank;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("ping")
@RegisterRestClient
@RegisterProvider(InternalErrorExceptionMapper.class)
public interface PingRestClient {

    @GET
    @Path("{param}")
    Response getPing(@PathParam("param") String param);
}
