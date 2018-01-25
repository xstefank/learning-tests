package org.learn.lt.impl;

import org.learn.lt.Service;

public class Service2 implements Service {
    public String getName() {
        return "Service2";
    }

    public void execute() {
        System.out.println("Executing Serivce2");
    }
}
