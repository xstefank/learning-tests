package io.xstefank;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.xstefank.Dummy;

@RegisterForReflection
public class QuarkedDummy implements Dummy {
    @Override
    public String hello() {
        return "QuarkedDummy hello";
    }
}
