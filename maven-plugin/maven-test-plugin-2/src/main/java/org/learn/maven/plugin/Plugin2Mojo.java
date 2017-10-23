package org.learn.maven.plugin;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(
        name = "plugin2",
        defaultPhase = LifecyclePhase.COMPILE,
        threadSafe = true
)
public class Plugin2Mojo extends Plugin1Mojo {
}
