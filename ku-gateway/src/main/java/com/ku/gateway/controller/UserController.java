package com.ku.gateway.controller;

import com.ku.gateway.filter.UserFilter;
import com.ku.gateway.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Users", description = "User information")
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, name = "findUser")
    @Operation(summary = "Find user")
    public String findUser() {
        return userService.getObject();
    }

    @GetMapping("/findAll")
    @Operation(summary = "Find users")
    public String findAll(
        @Parameter(description = "First name", example = "Ivan")
        @RequestParam(value = "name", required = false) Optional<String> name,
        @Parameter(description = "Username", example = "IvanIvanov12")
        @RequestParam(value = "userName", required = false)  Optional<String> username,
        @Parameter(description = "Password", example = "123456789")
        @RequestParam(value = "password", required = false)  Optional<String> password,
        @Parameter(description = "Offset", example = "0")
        @RequestParam(defaultValue = "0") Optional<Integer> offset,
        @Parameter(description = "Limit", example = "20")
        @RequestParam(defaultValue = "20") Optional<Integer> limit
    ) {
        return userService.findAll(
            new UserFilter()
                .setName(name)
                .setUsername(username)
                .setPassword(password)
                .setLimit(limit)
                .setOffset(offset));
    }
    @Autowired
    public void setPingGeneratorService(UserService userService) {
        this.userService = userService;
    }
}

