package com.ku.gateway.controller;

import com.ku.gateway.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Users", description = "User information")
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find user")
    public String findUser() {
        return userService.getObject();
    }

    @Autowired
    public void setPingGeneratorService(UserService userService) {
        this.userService = userService;
    }
}

