package com.ku.users.controller;

import com.ku.users.dto.UserDto;
import com.ku.users.dto.UserListDto;
import com.ku.users.entity.Gender;
import com.ku.users.filter.UserFilter;
import com.ku.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find content by id")
    public UserDto findById(
        @Parameter(description = "Content id", required = true, example = "1")
        @PathVariable Long id
    ) {
        return userService.findById(id);
    }

    @GetMapping("/findAll")
    @Operation(summary = "Find users")
    public List<UserListDto> findAll(
        @Parameter(description = "First name", example = "Ivan")
        @RequestParam(value = "name", required = false) String name,
        @Parameter(description = "Surname", example = "Ivanov")
        @RequestParam(value = "surname", required = false)  String surname,
        @Parameter(description = "Username", example = "IvanIvanov12")
        @RequestParam(value = "userName", required = false)  String username,
        @Parameter(description = "Age", example = "18")
        @RequestParam(defaultValue = "18") Long age,
        @RequestParam(value = "gender", required = false)
        @Parameter(description = "Gender", example = "FEMALE") Gender gender,
        @Parameter(description = "Offset", example = "0")
        @RequestParam(defaultValue = "0") Integer offset,
        @Parameter(description = "Limit", example = "20")
        @RequestParam(defaultValue = "20") Integer limit
    ) {
        return userService.findAll(
            new UserFilter()
                .setName(name)
                .setUsername(username)
                .setSurName(surname)
                .setAge(age)
                .setGender(gender)
                .setLimit(limit)
                .setOffset(offset));
    }

    @Autowired
    public void setCompanyService(UserService userService) {
        this.userService = userService;
    }
}
