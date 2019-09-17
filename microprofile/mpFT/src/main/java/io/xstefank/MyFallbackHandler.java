package io.xstefank;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class MyFallbackHandler implements FallbackHandler<String> {
    @Override
    public String handle(ExecutionContext executionContext) {
        return "fallback value";
    }
}
