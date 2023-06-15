package com.ku.gateway.service;

import com.ku.gateway.filter.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private RestTemplate restTemplate;

    public String findById(Long id) {
        return restTemplate.getForObject("http://localhost:8084/" + id, String.class);
    }

    public String findAll(UserFilter filter) {
        StringBuilder findAllUrlBuilder = new StringBuilder("http://localhost:8084/findAll/?");
        filter.getName().ifPresent(name -> findAllUrlBuilder.append("&name=").append(name));
        filter.getSurName().ifPresent(surname -> findAllUrlBuilder.append("&surname=").append(surname));
        filter.getUsername().ifPresent(username -> findAllUrlBuilder.append("&username=").append(username));
        filter.getAge().ifPresent(age -> findAllUrlBuilder.append("&age=").append(age));
        filter.getGender().ifPresent(gender -> findAllUrlBuilder.append("&gender=").append(gender));
        filter.getOffset().ifPresent(offset -> findAllUrlBuilder.append("&offset=").append(offset));
        filter.getLimit().ifPresent(limit -> findAllUrlBuilder.append("&limit=").append(limit));
        return restTemplate.getForObject(findAllUrlBuilder.toString(), String.class);
    }
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
