package io.xstefank;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;

@RequestScoped
public class MyRequestScopedBean {

    private UUID uuid = UUID.randomUUID();

    public UUID getUuid() {
        return uuid;
    }
}
