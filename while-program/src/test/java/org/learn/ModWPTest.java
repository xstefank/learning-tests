package org.learn;

import org.junit.Assert;
import org.junit.Test;

public class ModWPTest {

    private ModWP modWP = new ModWP();

    @Test
    public void testMod() {
        Assert.assertEquals(0, modWP.apply(6, 3));
        Assert.assertEquals(1, modWP.apply(7, 3));
        Assert.assertEquals(2, modWP.apply(8, 3));
    }

}
