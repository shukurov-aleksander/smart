package com.ku.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/data")
    public String getSimpleData() {
        return "Hello from Users module!";
    }
}
