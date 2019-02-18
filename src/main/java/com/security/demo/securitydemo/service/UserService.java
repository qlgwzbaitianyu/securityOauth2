package com.security.demo.securitydemo.service;

import com.security.demo.securitydemo.dto.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User addUser(User user);

    void deleteUserById(int id);

    User findUserById(int id);

    List<User> findUserByName(String name, Pageable pageable);

    List<User> findAllUser();

    User updateUser(User user);
}
