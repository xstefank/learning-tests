package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() throws MalformedURLException {
        URL depImplJar = new File("/home/mstefank/GIT/xstefank/learning-tests/service-loader-tt/dep-impl/target/dep-impl-0.0.1.jar").toURI().toURL();
        System.out.println(depImplJar);

        URLClassLoader ucl = new URLClassLoader(new URL[]{depImplJar}, Thread.currentThread().getContextClassLoader());
        
        ServiceLoader<Dummy> serviceLoader = ServiceLoader.load(Dummy.class, ucl);
        System.out.println("service loader");
        serviceLoader.iterator().forEachRemaining(x -> System.out.println("class: " + x.getClass().getName() + ", " + x.hello()));


        return Response.ok("Application running successfully").build();
    }
}
