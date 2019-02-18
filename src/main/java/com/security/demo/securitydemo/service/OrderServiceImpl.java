package com.security.demo.securitydemo.service;

import com.security.demo.securitydemo.dto.Order;
import com.security.demo.securitydemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
}
