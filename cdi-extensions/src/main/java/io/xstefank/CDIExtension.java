package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

@ApplicationScoped
public class CDIExtension implements Extension {

    public void observe(@Observes ProcessAnnotatedType<?> type) {
        System.out.println("XXXXXXXXXXXXX " + type.getAnnotatedType());
    }
    
}
