package io.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;
import org.jboss.jandex.MethodInfo;
import org.jboss.jandex.Type;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Path("/ping")
public class PingResource {

    @Inject
    Dummy dummy;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("jandex")
    public String jandex() throws IOException, NoSuchMethodException {
        Indexer indexer = new Indexer();

        indexer.index(getClass().getClassLoader().getResourceAsStream("io/xstefank/TestClass.class"));

        Index index = indexer.complete();

        ClassInfo testClass = index.getClassByName(DotName.createSimple(TestClass.class.getName()));
        List<AnnotationInstance> compensates = testClass.annotations().get(DotName.createSimple(Compensate.class.getName()));


        Method compensate = TestClass.class.getMethod("compensate", String.class);
        System.out.println(compensate);

        DotName STRING = DotName.createSimple(String.class.getName());
        System.out.println(Type.create(STRING, Type.Kind.CLASS).equals(Type.create(DotName.createSimple(String.class.getName()), Type.Kind.CLASS)));

        return "hello";
    }

    private Type[] getParameters(Class<?>[] parameterTypes) {
        Type[] jandexParams = new Type[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            jandexParams[i] = Type.create(DotName.createSimple(parameterType.getName()), Type.Kind.PRIMITIVE);
        }

        return jandexParams;
    }

}
