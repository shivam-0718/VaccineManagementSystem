package com.vms.vaccine.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = {"/", "/home"})
    @Operation(summary = "GET Operation", description = "This method is used to greet the user with a welcome message.")
    public String greet() {
        return "Welcome to Vaccine Management application.";
    }
}
