package org.test.learn;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCreatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreateExactLengthString() {
        String expected = "   ";
        Assert.assertEquals(expected, new StringCreator().createSpaceString(expected.length()));
    }

    @Test
    public void testNegativeLengthCreateString() {
        expectedException.expect(IllegalArgumentException.class);
        new StringCreator().createSpaceString(-1);
    }

}
