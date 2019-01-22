package org.xstefank;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ping")
@Tag(name = "Ping endpoint", description = "Endpoint available for ping")
public class PingResource {
    
    @GET
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Valid ping", content = @Content(mediaType = MediaType.TEXT_PLAIN)),
            @APIResponse(responseCode = "500", description = "Error pinging")
    })
    public Response ping() {
        return Response.ok("Application running successfully").build();
    }
}
