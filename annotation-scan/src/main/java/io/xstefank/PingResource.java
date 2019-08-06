package io.xstefank;

import io.xstefank.annotations.AnnotatedClass;
import io.xstefank.annotations.Dummy;
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
import java.lang.reflect.AnnotatedType;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws NoSuchMethodException, IOException {

        Class<?> clazz = AnnotatedClass.class;
        System.out.println(clazz.getMethod("methodWithDummy").getAnnotation(Dummy.class));
        System.out.println(clazz.getMethod("methodWithoutDummy").getAnnotation(Dummy.class));

        for (AnnotatedType annotatedType : clazz.getAnnotatedInterfaces()) {
            System.out.println(annotatedType.getType());
            System.out.println(annotatedType.getAnnotationsByType(Dummy.class));
        }

        Indexer indexer = new Indexer();
        InputStream stream = getClass().getClassLoader()
            .getResourceAsStream("io/xstefank/annotations/AnnotatedClass.class");
        indexer.index(stream);
        Index index = indexer.complete();

        ClassInfo classInfo = index.getClassByName(DotName.createSimple("io.xstefank.annotations.AnnotatedClass"));
        System.out.println(classInfo.annotations().get(DotName.createSimple("io.xstefank.annotations.Dummy")));

        return "hello";
    }
}
