package org.learn.axonframework.orderservice.util;

import java.util.UUID;

public class Util {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
