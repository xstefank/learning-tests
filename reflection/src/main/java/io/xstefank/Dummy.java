package io.xstefank;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Dummy {
    
    public CompletionStage<String> foo() {
        return CompletableFuture.supplyAsync(() -> "FOO!");
    }
}
