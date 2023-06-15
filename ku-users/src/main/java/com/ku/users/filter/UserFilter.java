package com.ku.users.filter;

import com.ku.users.entity.Gender;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserFilter {
    private Long id;
    private String name;
    private String surName;
    private Long age;
    private Gender gender;
    private String username;
    private String password;
    private LocalDateTime insertedDateAtUtc;
    private LocalDateTime updatedDateAtUtc;
    private Integer limit;
    private Integer offset;
}
