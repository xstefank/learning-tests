package org.learn;

import org.junit.Assert;
import org.junit.Test;

public class DivWPTest {

    private DivWP divWP = new DivWP();

    @Test
    public void divTest() {
        Assert.assertEquals(2, divWP.apply(7, 3));
        Assert.assertEquals(3, divWP.apply(9, 3));
        Assert.assertEquals(0, divWP.apply(2, 4));
    }

}
