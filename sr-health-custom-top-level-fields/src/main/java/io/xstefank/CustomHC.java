package io.xstefank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.smallrye.health.SmallRyeHealth;
import io.smallrye.health.SmallRyeHealthReporter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/custom-health")
public class CustomHC {

    @Inject
    SmallRyeHealthReporter smallRyeHealthReporter;

    @GET
    @Path("/health")
    public Response reportHealth() throws JsonProcessingException {
        SmallRyeHealth health = smallRyeHealthReporter.getHealth();

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode objectNode = objectMapper.readValue(health.getPayload().toString(), ObjectNode.class);
        objectNode.put("customKey", "customValue");

        return Response.ok(objectNode).build();

    }
}
