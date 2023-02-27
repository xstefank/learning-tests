package com.example.testspringweb.rest;

import com.example.testspringweb.model.Avenger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/avenger")
public class AvengerController {

    @Value(value = "${test.property}")
    private String testProperty;

    @GetMapping
    public List<Avenger> getAvengers() {
        System.out.println("testProperty = " + testProperty);
        return List.of(
            new Avenger("Tony Stark", "Iron Man", false),
            new Avenger("Steve Rogers", "Captain America", false)
        );
    }
}
