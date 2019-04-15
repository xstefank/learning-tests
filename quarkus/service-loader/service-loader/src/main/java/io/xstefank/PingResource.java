package io.xstefank;

import org.xstefank.Dummy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws MalformedURLException, ClassNotFoundException {
        URL depImplJar = new File(System.getProperty("additional-cp")).toURI().toURL();

        URLClassLoader ucl = new URLClassLoader(new URL[]{depImplJar});
        System.out.println(ucl.loadClass("io.xstefank.QuarkedDummy"));
        
        
        ServiceLoader<Dummy> serviceLoader = ServiceLoader.load(Dummy.class, ucl);
        System.out.println("service loader");
        serviceLoader.iterator().forEachRemaining(x -> System.out.println("class: " + x.getClass().getName() + ", " + x.hello()));
        
        return "hello";
    }
}
