package org.learn;

public class DivWP {

    public int apply(int x, int y) {
        int z = 0;
        int u = 0;
        int c = y;
        while (c <= x) {
            int v = 0;
            while (v != y) {
                v = v + 1;
                u = u + 1;
            }
            z = z + 1;
            c = c + y;
        }

        return z;
    }
}
