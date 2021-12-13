package io.xstefank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.smallrye.health.SmallRyeHealthReporter;
import io.smallrye.mutiny.Uni;

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
    public Uni<Response> reportHealth() throws JsonProcessingException {
        return smallRyeHealthReporter.getHealthAsync().onItem().transform(health -> {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode objectNode = null;
            try {
                objectNode = objectMapper.readValue(health.getPayload().toString(), ObjectNode.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            objectNode.put("customKey", "customValue");

            return Response.ok(objectNode).build();
        });

    }
}
