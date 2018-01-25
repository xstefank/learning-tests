package org.learn.lt.impl;

import org.learn.lt.Service;

public class Service1 implements Service {
    public String getName() {
        return "Service1";
    }

    public void execute() {
        System.out.println("Executing Service1");
    }
}
