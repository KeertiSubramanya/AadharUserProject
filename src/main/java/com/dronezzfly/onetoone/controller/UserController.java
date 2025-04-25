package com.dronezzfly.onetoone.controller;

import com.dronezzfly.onetoone.dtos.UserDTO;
import com.dronezzfly.onetoone.model.Users;
import com.dronezzfly.onetoone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto){
        return userService.createUser(dto);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){

        return  userService.getAllUsers();
    }
}
