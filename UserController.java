package com.telecomsystem.controller;

import com.telecomsystem.model.User;
import com.telecomsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
