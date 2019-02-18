package com.security.demo.securitydemo.controller;

import com.security.demo.securitydemo.dto.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.hateoas.Resource;
import com.security.demo.securitydemo.dto.Role;
import com.security.demo.securitydemo.dto.User;
import com.security.demo.securitydemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/users")
@PropertySource("classpath:test.properties")
public class UserController {

    @Value("${testname}")
    private String name;

    @Autowired
    UserServiceImpl userService;

    /**
     * add a user
     * @param user
     * @return
     */
    @PostMapping(path = "/addUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User responseUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseUser);
    }

    /**
     * find all the user
     * @param
     * @return
     */

    @GetMapping(path = "/all", produces = "application/json")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<User>> getAllUsers(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<User> responseUsers = userService.findAllUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseUsers);
    }


    /**
     * find a user by id
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}",produces = "application/json")
    public ResponseEntity<Resource<User>> getUserById(@PathVariable int id){
        User resposneUser = userService.findUserById(id);

        Link selfLink = linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel();
        Link allLink = linkTo(methodOn(UserController.class).getAllUsers()).withRel("allUsers");
        Resource<User> resources = new Resource<>(resposneUser, selfLink);
        resources.add(allLink);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resources);
    }

    /**
     * find user by name
     * @param name
     * @return
     */
    @GetMapping
    public ResponseEntity<List<User>> getUserByName(@RequestParam(value = "userName") String name, @RequestParam(value = "pageNumber") String pageNumber){
        Pageable firstPageWithTwoElements = PageRequest.of(Integer.parseInt(pageNumber), 2);
        List<User> responseUsers = userService.findUserByName(name, firstPageWithTwoElements);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseUsers);
    }

    @GetMapping(path = "/me")
    public Object getUserDetail(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
    }

    /**
     * update a user
     * @param user
     * @return
     */
    @PutMapping(path = "/updateUser", produces = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User responseUser = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseUser);
    }

    /**
     * delete a user
     * @param id
     * @return
     */
    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
