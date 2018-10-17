package org.xstefank;

import org.jboss.as.server.suspend.ServerActivity;
import org.jboss.as.server.suspend.ServerActivityCallback;
import org.jboss.as.server.suspend.SuspendController;

public class App {

    public static void main(String[] args) {
        SuspendController suspendController = new SuspendController();
        suspendController.registerActivity(new TestActivity());

        suspendController.suspend(1000);
        suspendController.resume();
        
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
            throw new RuntimeException("asdfasdf");
        }
    }
}
