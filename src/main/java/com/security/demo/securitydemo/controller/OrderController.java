package com.security.demo.securitydemo.controller;

import com.security.demo.securitydemo.dto.Order;
import com.security.demo.securitydemo.dto.User;
import com.security.demo.securitydemo.service.OrderServiceImpl;
import com.security.demo.securitydemo.service.UserServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Order> getOrderById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.getOrderById(id));
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.getAllOrder());
    }

    /**
     * add order
     * @param order
     * @return
     */
    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        //User user = userService.findUserById(1);
        //Order order1 = new Order(1, "placed", user, new LinkedList<>());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.addOrder(order));
    }

    @PutMapping(path = "/update", produces = "application/json")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.updateOrder(order));
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity deleteOrder(@PathVariable int id){
        orderService.deleteOrderById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
