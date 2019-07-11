package io.xstefank;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        throw new RuntimeException("ServletContextListener context initialized -- POSSIBLE LRA SCAN");
    }
}
