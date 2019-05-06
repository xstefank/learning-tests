package io.xstefank;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String jsonString = "{\"array\":[{\"name\":\"test\"}, {\"name\":\"test2\"}]}";

        JsonReader reader = Json.createReader(new StringReader(jsonString));
        JsonObject json = reader.readObject();

        JsonArray array = json.getJsonArray("array");

        for (JsonObject object : array.getValuesAs(JsonObject.class)) {
            System.out.println(object);
        }
        
        
        return "hello";
    }
}
