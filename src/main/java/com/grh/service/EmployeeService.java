package com.grh.service;

import com.grh.reposetory.EmployeeRepo;
import com.grh.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeServiceIn{
    
    @Autowired
    private EmployeeRepo repository;

    public Employee createEmp(Employee Employee){
        return repository.save(Employee);
    }

    @Override
    public Boolean deleteEmp(Long id) {
        Optional<Employee> EmployeeOptional = repository.findById(id);
        if(EmployeeOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }



    public List<Employee> finAllEmp(){
        return repository.findAll();
    }

    public String updateEmp(Employee Employee, Long id){
        Optional<Employee> EmployeeOptional=repository.findById(id);
        if(EmployeeOptional.isPresent()){
            Employee updateEmployee = EmployeeOptional.get();
            updateEmployee.setName(Employee.getName());

        }

        return "";
    }


}
