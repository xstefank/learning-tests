package io.xstefank;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        File file = new File(PingResource.class.getClassLoader().getResource("test.json").getFile());
        System.out.println(new ObjectMapper().readTree(file));
        
        String fileName = PingResource.class.getClassLoader().getResource("dir/test.json").getFile();
        file = new File(URLDecoder.decode(fileName, "UTF-8"));
        System.out.println(new ObjectMapper().readTree(file));


        fileName = PingResource.class.getClassLoader().getResource("dir with spaces/test.json").getFile();
        file = new File(URLDecoder.decode(fileName, "UTF-8"));
        System.out.println(new ObjectMapper().readTree(file));
        
        return "hello";
    }
}
