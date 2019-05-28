package io.xstefank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestBeanImpl implements TestBean {
    @Override
    public String test() {
        return "test";
    }
}
