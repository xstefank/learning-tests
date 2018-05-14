package org.learn.stuff8.model;

import java.util.regex.Pattern;

public class TestYAML {

    private Pattern pattern;

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "TestYAML{" +
                "pattern=" + pattern +
                '}';
    }
}
