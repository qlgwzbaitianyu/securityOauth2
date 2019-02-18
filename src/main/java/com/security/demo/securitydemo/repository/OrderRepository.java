package com.security.demo.securitydemo.repository;

import com.security.demo.securitydemo.dto.Order;
import com.security.demo.securitydemo.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
