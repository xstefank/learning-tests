package org.learn.stuff8;

import org.junit.Assert;
import org.junit.Test;

public class StuffTest {
    
    @Test
    public void testStringEquality() {
        String s = "asdf";
        String t = "asdf";

        Assert.assertTrue(s == t);
        Assert.assertTrue(s.equals(t));
        Assert.assertFalse(s == new String("asdf"));
        Assert.assertTrue(s.equals(new String("asdf")));
    }
}
