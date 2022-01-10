package io.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Optional;

@Path("/ping")
public class PingResource {

    @ConfigProperty(name = "smallrye.health.additional.property", defaultValue = "")
    Optional<Map<String, String>> additonalProperties;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        System.out.println(additonalProperties.orElse(Map.of("values", "not provided")));
        return "Hello RESTEasy";
    }
}