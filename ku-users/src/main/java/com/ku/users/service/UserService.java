package com.ku.users.service;

import com.ku.users.dto.UserListDto;
import com.ku.users.filter.UserFilter;
import com.ku.users.repository.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    public List<UserListDto> findAll(UserFilter filter) {
        return userDao.findAll(filter);
    }

    @Autowired
    public void setCompanyDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
