package io.xstefank;

import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/json")
public class JsonResource {

    @POST
    public String getJson(JsonObject json) {
        System.out.println(json);
        return json.toString();
    }
}
