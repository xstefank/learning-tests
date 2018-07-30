package org.xstefank;

import org.junit.Assert;
import org.junit.Test;

public class LabeledLoopsTest {
    
    @Test
    public void testSimpleLoops() {
        
        int result = 0;
        
        outer:
        for (int i = 0; i < 5; i++) {
            inner:
            for (int j = 0; j < 5; j++) {
                result += i + j;
            }
        }

        Assert.assertEquals(100, result);
    }

    @Test
    public void testBreakOuterLoop() {

        int result = 0;

        outer:
        for (int i = 0; i < 5; i++) {
            inner:
            for (int j = 0; j < 5; j++) {
                if (i == 3) {
                    break outer;
                }
                result += i + j;
            }
        }

        Assert.assertEquals(45, result);
    }

    @Test
    public void testBreakInnerLoop() {

        int result = 0;

        outer:
        for (int i = 0; i < 5; i++) {
            inner:
            for (int j = 0; j < 5; j++) {
                if (i == 3) {
                    break inner;
                }
                result += i + j;
            }
            result = 10;
        }

        Assert.assertEquals(10, result);
    }

    @Test
    public void testContinueOuterLoop() {

        int result = 0;

        outer:
        for (int i = 0; i < 5; i++) {
            inner:
            for (int j = 0; j < 5; j++) {
                if (i == 3) {
                    continue outer;
                }
                result += i + j;
            }
            result = 10;
        }
        
        result += 10;

        Assert.assertEquals(20, result);
    }
}
