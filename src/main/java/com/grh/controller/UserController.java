package com.grh.controller;


<<<<<<< HEAD
import java.util.List;

=======
import com.grh.entites.Employee;
import com.grh.entites.User;
import com.grh.service.UserService;
>>>>>>> f4ccbac88e991e132a2433232e0e99229fe748bf
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.entites.User;
import com.grh.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
   private UserService service;

    @GetMapping("all")
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

    @PutMapping("update/{id}")
    public ResponseEntity<String> deleteUserByID(@RequestBody User user, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(user, id));
    }


}
