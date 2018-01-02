package org.learn;

public class PowerWP {

    private TimesWP timesWP = new TimesWP();

    public int apply(int x, int y) {
        int z = 0;
        z = z + 1;
        int u = 0;
        while (u != y) {
            z = timesWP.apply(z, x);
            u = u + 1;
        }

        return z;
    }
}
