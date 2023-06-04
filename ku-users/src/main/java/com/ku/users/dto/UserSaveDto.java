package com.ku.users.dto;

import com.ku.users.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Schema(description = "User save or update data transfer object")
@Accessors(chain = true)
public class UserSaveDto {
    @Schema(description = "Id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ivan")
    private String name;
    @Schema(description = "Surname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ivanov")
    private String surName;
    @Schema(description = "Age", requiredMode = Schema.RequiredMode.REQUIRED, example = "18")
    private Long age;
    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED, example = "MALE")
    private Gender gender;
    @Schema(description = "Username", requiredMode = Schema.RequiredMode.REQUIRED, example = "IvanIvanov")
    private String username;
    @Schema(description = "Password", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    private String password;
}
