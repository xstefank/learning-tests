package org.xstefank;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @GET
    public Response getAvengers() {

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(Avenger.name("Iron Man")
                .realName("Tony Stark")
                .alive(true)
                .build());

        return Response.ok(json).build();
    }
}
