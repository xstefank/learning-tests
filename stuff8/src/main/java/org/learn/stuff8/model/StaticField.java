package org.learn.stuff8.model;

import java.io.IOException;

public class StaticField {
    
    private static String s;

    static {
        try {
            s = generateString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateString() throws IOException {
        return "Random string";
    }
}
