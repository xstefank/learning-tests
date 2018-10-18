package org.xstefank;

import org.jboss.as.server.suspend.ServerActivity;
import org.jboss.as.server.suspend.ServerActivityCallback;
import org.jboss.as.server.suspend.SuspendController;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {

    private static final String FAIL_MESSAGE = "IGNORE - test failure";
    
    @Test
    public void testSuspend() throws IOException {
        SuspendController suspendController = new SuspendController();
        suspendController.registerActivity(new TestActivity());

        suspendController.suspend(1000);
        suspendController.resume();

        String output = new String(Files.readAllBytes(Paths.get("server.log")));

        Assert.assertTrue("Exception type of the resume failure is not included in the log message",
                output.contains(RuntimeException.class.getSimpleName()));
        Assert.assertTrue("Cause of the resume failure is not included in the log message",
                output.contains(FAIL_MESSAGE));
    }

    private static final class TestActivity implements ServerActivity {

        @Override
        public void preSuspend(ServerActivityCallback listener) {
            //not required
        }

        @Override
        public void suspended(ServerActivityCallback listener) {
            //not required
        }

        @Override
        public void resume() {
            throw new RuntimeException(FAIL_MESSAGE);
        }
    }
}
