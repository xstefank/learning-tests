package io.xstefank;

import org.jboss.resteasy.spi.AsyncClientResponseProvider;

import javax.ws.rs.ext.Provider;
import java.util.concurrent.CompletionStage;

@Provider
public class DummyAsyncClientResponseProvider implements AsyncClientResponseProvider<String> {
    @Override
    public String fromCompletionStage(CompletionStage<?> completionStage) {
        return "Injected response";
    }
}
