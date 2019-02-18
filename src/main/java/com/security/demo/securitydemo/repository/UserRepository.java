package com.security.demo.securitydemo.repository;

import com.security.demo.securitydemo.dto.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findUserById(int id);


    List<User> findUserByName(String name, Pageable pageable);
}
