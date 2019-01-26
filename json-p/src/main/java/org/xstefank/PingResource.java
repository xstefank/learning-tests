package org.xstefank;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        JsonObject json = Json.createObjectBuilder()
                .add("name", "Iron Man")
                .add("realName", "Tony Stark")
                .add("alive", "true")
                .build();

        System.out.println(json.toString());

        JsonReader reader = Json.createReader(new StringReader(json.toString()));
        System.out.println(reader.readObject().getString("name"));

        return Response.ok(json.toString()).build();
    }
}
