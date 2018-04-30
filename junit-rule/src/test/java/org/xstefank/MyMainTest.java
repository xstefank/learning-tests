package org.xstefank;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMainTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testHello() {
        MyMain myMain = new MyMain();

        Assert.assertEquals("Hello world!", myMain.sayHello("world"));
    }

    @Test
    public void testHelloException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid argument");

        MyMain myMain = new MyMain();

        Assert.assertEquals("Hello world!", myMain.sayHello("paper"));
    }

}
