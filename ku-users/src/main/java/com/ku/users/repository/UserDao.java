package com.ku.users.repository;

import com.ku.users.dto.UserListDto;
import com.ku.users.entity.Gender;
import com.ku.users.filter.UserFilter;
import java.sql.ResultSet;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private static final String FIND_ALL_QUERY = """
        SELECT u.id, u.name, u.surname, u.age, u.gender, u.username
        FROM users u
        WHERE (:name::text IS NULL OR u.name = :name)
            AND (:surname::text IS NULL OR u.surname = :surname)
            AND (:age::integer  IS NULL OR u.age = :age)
            AND (:gender::gender_enum  IS NULL OR u.gender = :gender::gender_enum)
            AND (:username::text  IS NULL OR u.username = :username)
        LIMIT :limit OFFSET :offset
    """;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<UserListDto> findAll(UserFilter filter) {
        return namedParameterJdbcTemplate.query(FIND_ALL_QUERY, filteredFieldsMap(filter), this::buildUserListDto);
    }

    @SneakyThrows
    public UserListDto buildUserListDto(ResultSet rs, int rowNum) {
        return new UserListDto()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setSurName(rs.getString("surname"))
            .setUsername(rs.getString("username"))
            .setGender(Gender.valueOf(rs.getString("gender")))
            .setAge(rs.getLong("age"));
    }

    public MapSqlParameterSource filteredFieldsMap(UserFilter filter) {
        return new MapSqlParameterSource()
            .addValue("name", filter.getName())
            .addValue("surname", filter.getSurName())
            .addValue("username", filter.getUsername())
            .addValue("age", filter.getAge())
            .addValue("gender", filter.getGender() == null ? null : filter.getGender().toString())
            .addValue("limit", filter.getLimit())
            .addValue("offset", filter.getOffset());
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
