package org.learn;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class IfWPTest {

    private IfWP ifWP = new IfWP();

    @Test
    public void testIfSimple() {
        AtomicInteger t = new AtomicInteger(1);
        ifWP.apply(true, aString -> t.set(0));
        Assert.assertEquals(0, t.get());
    }

    @Test
    public void testIfSimpleNegative() {
        AtomicInteger t = new AtomicInteger(1);
        ifWP.apply(false, aString -> t.set(0));
        Assert.assertEquals(1, t.get());
    }

    @Test
    public void testIfElse() {
        AtomicInteger t = new AtomicInteger(1);
        ifWP.apply(true, aString -> t.set(0), aString -> t.set(2));
        Assert.assertEquals(0, t.get());
    }

    @Test
    public void testIfElseNegative() {
        AtomicInteger t = new AtomicInteger(1);
        ifWP.apply(false, aString -> t.set(0), aString -> t.set(2));
        Assert.assertEquals(2, t.get());
    }

}
