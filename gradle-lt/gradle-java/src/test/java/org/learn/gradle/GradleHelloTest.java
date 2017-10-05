package org.learn.gradle;

import org.junit.Assert;
import org.junit.Test;

public class GradleHelloTest {

    @Test
    public void testGradleHello() {
        System.out.println("executing testGradleHello()");
        Assert.assertEquals("Hello Gradle", new GradleHello().hello());
    }

    @Test
    public void testSystemProperty() {
        System.out.println("got property some.prop=" + System.getProperty("some.prop"));
        Assert.assertEquals("value", System.getProperty("some.prop"));
    }

}