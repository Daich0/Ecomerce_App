package com.ecomerce.fis.controllers;

import com.ecomerce.fis.models.UserModel;
import com.ecomerce.fis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public UserModel getUser(@RequestBody UserModel user){
//        System.out.println();
        return user;
    }
    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        System.out.println(user);
        return this.userService.createUser(user);
    }
//    @GetMapping
//    public String getUser(){
//        return "ok";
//    }
}
