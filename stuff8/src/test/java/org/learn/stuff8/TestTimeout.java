package org.learn.stuff8;

import org.junit.Ignore;
import org.junit.Test;

public class TestTimeout {

    @Test(timeout = 1000)
    @Ignore
    public void testTimeout() {
        while (true) {

        }
    }
}
