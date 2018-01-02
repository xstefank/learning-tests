package org.learn;

import org.junit.Assert;
import org.junit.Test;

public class PowerWPTest {

    private PowerWP powerWP = new PowerWP();

    @Test
    public void testPower() {
        Assert.assertEquals(8, powerWP.apply(2, 3));
        Assert.assertEquals(9, powerWP.apply(3, 2));
        Assert.assertEquals(27, powerWP.apply(3, 3));
    }

}
