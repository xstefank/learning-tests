package io.xstefank;

import javax.ws.rs.Path;

@Path("/ping")
public class PingResource extends PingSuperclass implements PingInterface {

    public String hello() {
        return "hello";
    }
}
