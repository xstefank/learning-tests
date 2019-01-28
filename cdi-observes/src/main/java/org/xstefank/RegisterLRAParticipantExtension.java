package org.xstefank;

import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.WithAnnotations;
import java.util.ArrayList;
import java.util.List;

public class RegisterLRAParticipantExtension implements Extension {

    public static final List<String> names = new ArrayList<>();

    public void register(@Observes @WithAnnotations(RegisterLRAParticipant.class) ProcessAnnotatedType<?> type) {
        String name = type.getAnnotatedType().getJavaClass().getName();
        Logger.getLogger("SADFSAFDSADF").error("XXXXXXXXXXXXXXXXXXXX " + name);

        names.add(name);
        
    }
    
}
