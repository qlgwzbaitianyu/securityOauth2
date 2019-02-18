package com.security.demo.securitydemo.service;

import com.security.demo.securitydemo.dto.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    Order getOrderById(int id);

    List<Order> getAllOrder();

    void deleteOrderById(int id);

    Order updateOrder(Order order);
}
