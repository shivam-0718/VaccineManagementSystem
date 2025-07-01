package com.vms.vaccine.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = {"/", "/home"})
    public String greet() {
        return "Welcome to Vaccine Management application.";
    }
}
