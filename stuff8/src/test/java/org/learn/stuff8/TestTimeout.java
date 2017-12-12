package org.learn.stuff8;

import org.junit.Test;

public class TestTimeout {

    @Test(timeout = 1000)
    public void testTimeout() {
        while (true) {

        }
    }
}
