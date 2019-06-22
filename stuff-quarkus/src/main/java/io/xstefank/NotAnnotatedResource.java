package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class NotAnnotatedResource {
    
    @GET
    public String get() {
        return "hello world";
    }
}
