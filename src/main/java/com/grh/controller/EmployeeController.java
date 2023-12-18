package com.grh.controller;

import java.util.List;

import com.grh.service.employeBydep.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.entites.Employee;
import com.grh.service.employeBydep.EmployeeByDepartment;
import com.grh.service.EmployeeService;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> allEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(service.finAllEmp());
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmp(employee));
    }
    

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteEmployeeByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteEmp(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> deleteEmployeeByID(@RequestBody Employee employee, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateEmp(employee, id));
    }

    @GetMapping("by-Dep")
    public ResponseEntity<EmployeeResult> getEmpByDep(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeByDep());
    }
}
