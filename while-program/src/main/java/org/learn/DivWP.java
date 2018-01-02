package org.learn;

public class DivWP {

    public int apply(int x, int y) {
        int z = 0;
        int u = 0;
        while (u < x) {
            int v = 0;
            while (v != y) {
                v = v + 1;
                u = u + 1;
            }
            z = z + 1;
        }

        if (u > x) {
            z = z - 1;
        }

        return z;
    }
}
