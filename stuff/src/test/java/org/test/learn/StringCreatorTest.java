package org.test.learn;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCreatorTest {

    private StringCreator stringCreator = new StringCreator();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreateExactLengthString() {
        String expected = "   ";
        Assert.assertEquals(expected, stringCreator.createSpaceString(expected.length()));
    }

    @Test
    public void testNegativeLengthCreateString() {
        expectedException.expect(IllegalArgumentException.class);
        stringCreator.createSpaceString(-1);
    }

    @Test
    public void testRemoveTrailSpaces() {
        Assert.assertEquals("simpleText", stringCreator.removeTrailingSpaces("simpleText   "));
        Assert.assertEquals("no so simple Text", stringCreator.removeTrailingSpaces("no so simple Text   "));
    }

}
