package com.ku.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Schema(description = "User list data transfer object for list of the users")
@Accessors(chain = true)
public class UserListDto {
    @Schema(description = "Id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ivan")
    private String name;
    @Schema(description = "Username", requiredMode = Schema.RequiredMode.REQUIRED, example = "IvanIvanov")
    private String username;
    @Schema(description = "Password", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    private String password;
}
