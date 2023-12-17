package com.grh.controller;


import com.grh.entites.User;
import com.grh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
   private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUser(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllUser());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteUsereByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }




}
