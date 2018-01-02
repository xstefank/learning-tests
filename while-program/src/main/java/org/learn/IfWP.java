package org.learn;

import java.util.function.Consumer;

public class IfWP {

    public void apply(boolean t, Consumer<String> f) {
        int v = 0;
        while (t && v == 0) {
            f.accept("test string");
            v = 1;
        }
    }

    public void apply(boolean t, Consumer<String> f1, Consumer<String> f2) {
        int v = 0;
        while (t && v == 0) {
            f1.accept("test string");
            v = 1;
        }

        while (v == 0) {
            f2.accept("test string");
            v = 1;
        }
    }

}
