package io.xstefank;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestServlet implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("----------------- Context initialized -----------------");
    }
}
