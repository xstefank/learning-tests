package org.learn.gradle;

import org.junit.Assert;
import org.junit.Test;

public class GradleHelloTest {

    @Test
    public void testGradleHello() {
        Assert.assertEquals("Hello Gradle", new GradleHello().hello());
    }

}