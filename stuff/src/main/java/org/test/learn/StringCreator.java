package org.test.learn;

public class StringCreator {

    public String createSpaceString(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Cannot create negative length string");
        }

        return String.format("%0" + length + "d", 0).replace('0', ' ');
    }
}
