package io.xstefank;

import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        java.nio.file.Path path = Paths.get("target/classes/META-INF/jandex.idx");

        Index index;
        
        try (FileInputStream input = new FileInputStream(path.toFile())) {
            IndexReader indexReader = new IndexReader(input);
            index = indexReader.read();
        }

        List<AnnotationInstance> annotations = index.getAnnotations(DotName.createSimple("io.xstefank.Custom"));

        for (AnnotationInstance annotation : annotations) {
            System.out.println(annotation.target().asClass());
            System.out.println("XXXXXXX");
        }
        


        return "hello";
    }
}
