package org.xstefank.lt.tramlt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xstefank.lt.tramlt.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/get")
    public String testGet() {
        return testService.testExecution();
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
