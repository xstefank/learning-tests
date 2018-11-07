package org.xstefank;

import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnotationIndexer {

    public void index() throws IOException {
        Indexer indexer = new Indexer();
        InputStream stream = getClass().getClassLoader()
                .getResourceAsStream("java/lang/Thread.class");
        indexer.index(stream);
        stream = getClass().getClassLoader()
                .getResourceAsStream("java/lang/String.class");
        indexer.index(stream);
        Index index = indexer.complete();
        DotName deprecated = DotName.createSimple("java.lang.Deprecated");
        List<AnnotationInstance> annotations = index.getAnnotations(deprecated);

        for (AnnotationInstance annotation : annotations) {
            switch (annotation.target().kind()) {
                case METHOD:
                    System.out.println(annotation.target());
                    break;
            }
        }
    }
}
