package io.xstefank;

import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@ApplicationScoped
public class Dummy {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws IOException {
        Logger log = Logger.getLogger("ASDFASDF");
        log.error("ASDFASDFASDF");

        Indexer indexer = new Indexer();
        
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            
            try (ZipInputStream zip = new ZipInputStream(url.openStream())) {
                ZipEntry ze = null;

                while ((ze = zip.getNextEntry()) != null) {
                    String entryName = ze.getName();
                    if (entryName.endsWith(".class")) {
                        indexer.index(cl.getResourceAsStream(entryName));
                    }
                }
            }
        }

        Index index = indexer.complete();

        List<AnnotationInstance> annotations = index.getAnnotations(DotName.createSimple("javax.ws.rs.Path"));

        for (AnnotationInstance annotation : annotations) {
            System.out.println(annotation.target().asClass());
            System.out.println("XXXXXXX");
        }
        

    }

}
