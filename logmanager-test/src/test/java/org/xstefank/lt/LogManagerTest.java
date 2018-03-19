package org.xstefank.lt;

import org.jboss.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogManagerTest {

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("org.jboss.logging.provider", "jboss");
        System.setProperty("logging.configuration", "file:/home/mstefank/GIT/xstefank/learning-tests/logmanager-test/src/test/resources/logging.properties");
    }

    @Test
    public void testLogging() {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(output);
        System.setOut(newOut);

        try {
            Logger log = Logger.getLogger("TEST_LOGGER");
            log.error("test error");
        } finally {
            System.setOut(oldOut);
            System.out.println(new String(output.toByteArray()));
        }


    }
}
