package org.learn;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TimesWPTest extends TestCase {

    private TimesWP timesWP = new TimesWP();

    @Test
    public void testTimes() {
        Assert.assertEquals(6, timesWP.apply(2, 3));
    }

}
