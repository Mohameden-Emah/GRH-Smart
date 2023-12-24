package com.grh.web;

import java.util.List;

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

import com.grh.entity.Conge;
import com.grh.service.serviceImpl.CongeService;
@RestController
@RequestMapping("api/conge")
public class CongeController {

    @Autowired
    private CongeService service;

    @GetMapping("all")
    public ResponseEntity<List<Conge>> allConge(){
        return ResponseEntity.status(HttpStatus.OK).body(service.finAllConge());
    }

    @PostMapping("create")
    public ResponseEntity<String> createConge(@RequestBody Conge conge ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createConge(conge));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteCongeByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteConge(id));
    }


}
