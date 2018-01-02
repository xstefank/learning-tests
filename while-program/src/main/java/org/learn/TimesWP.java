package org.learn;

public class TimesWP {

    public int apply(int x, int y) {
        int z = 0;
        int u = 0;
        while (u != x) {
            int v = 0;
            while (v != y) {
                z = z + 1;
                v = v + 1;
            }
            u = u + 1;
        }

        return z;
    }
}
