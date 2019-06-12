package io.xstefank;

import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        Index index;

        IndexReader indexReader = new IndexReader(getClass().getClassLoader().getResourceAsStream("META-INF/jandex.idx"));
        index = indexReader.read();

        List<AnnotationInstance> annotations = index.getAnnotations(DotName.createSimple("io.xstefank.Custom"));

        for (AnnotationInstance annotation : annotations) {
            System.out.println(annotation.target().asClass());
            System.out.println("XXXXXXX");
        }


        return "hello";
    }
}
