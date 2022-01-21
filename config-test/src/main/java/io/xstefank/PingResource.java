package io.xstefank;

import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        Map<String, String> stringStringMap = ((SmallRyeConfig) ConfigProvider.getConfig())
                .getOptionalValues("io.xstefank.check", String.class, String.class).orElse(new HashMap<>());

        System.out.println(stringStringMap);

        return "Hello RESTEasy";
    }
}