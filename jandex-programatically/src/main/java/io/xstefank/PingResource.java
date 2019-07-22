package io.xstefank;

import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/ping")
public class PingResource {

    @Inject
    Dummy dummy;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
//        dummy.getHello();
        return "hello";
    }
    
    @GET
    @Path("jandex")
    public String jandex() throws IOException {
        Indexer indexer = new Indexer();

        indexer.index(getClass().getClassLoader().getResourceAsStream("io/xstefank/TestClass.class"));

        Index index = indexer.complete();

        ClassInfo testClass = index.getClassByName(DotName.createSimple(TestClass.class.getName()));
        List<AnnotationInstance> lras = testClass.annotations().get(DotName.createSimple(LRA.class.getName()));
        System.out.println(lras.get(0).target().kind());

        return "hello";
    }
}
