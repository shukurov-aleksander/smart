package com.ku.gateway.filter;

import com.ku.gateway.entity.Gender;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserFilter {
    private Optional<Long> id;
    private Optional<String> name;
    private Optional<String> surName;
    private Optional<Long> age;
    private Optional<Gender> gender;
    private Optional<String> username;
    private Optional<String> password;
    private Optional<LocalDateTime> insertedDateAtUtc;
    private Optional<LocalDateTime> updatedDateAtUtc;
    private Optional<Integer> limit;
    private Optional<Integer> offset;
}
