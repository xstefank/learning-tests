package org.xstefank;

public class DummyOverride implements Dummy {


    @Override
    public String getFoo() {
        return "FOOOOOO";
    }

    @Override
    public String getBar() {
        return "bar";
    }
}
