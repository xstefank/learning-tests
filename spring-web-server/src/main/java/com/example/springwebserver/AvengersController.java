package com.example.springwebserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@ResponseBody
public class AvengersController {

    private AvengerService avengerService;

    @Autowired
    public AvengersController(AvengerService avengerService) {
        this.avengerService = avengerService;
    }

    @GetMapping("/avenger")
    public Collection<Avenger> getAvengers() {
        return avengerService.getAvengers();
    }

    @GetMapping(path = "/avenger/{id}")
    public Avenger getAvenger(@PathVariable String id) {
        return avengerService.getAvengerById(Long.parseLong(id));
    }

}
