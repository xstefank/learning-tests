package io.xstefank;

import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        Index index = new ClassPathIndexer().createIndex();

        ClassInfo clazz = index.getClassByName(DotName.createSimple("io.xstefank.TestInterface"));

        System.out.println(clazz);


        return "hello";
    }
    
    @GET
    @Path("2")
    public String jandexManually() throws IOException {
        Indexer indexer = new Indexer();

        InputStream stream = getClass().getClassLoader()
            .getResourceAsStream("java/util/Map.class");
        
        indexer.index(stream);
        
        stream = getClass().getClassLoader()
            .getResourceAsStream("java/util/Set.class");

        indexer.index(stream);
        
        Index index = indexer.complete();

        ClassInfo clazz = index.getClassByName(DotName.createSimple("java.util.Map"));
        System.out.println(clazz);

        clazz = index.getClassByName(DotName.createSimple("java.util.Set"));
        System.out.println(clazz);

        return "hello";
    }
}
