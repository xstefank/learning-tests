package io.xstefank;

import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Path("/ping2")
public class PingResource2 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Optional<Map<String, String>> additionalProperties = ((SmallRyeConfig) ConfigProvider.getConfig())
                .getOptionalValues("smallrye.health.additional.property", String.class, String.class);

        System.out.println(additionalProperties.orElse(Map.of("values", "not found")));
        return "Hello RESTEasy";
    }
}