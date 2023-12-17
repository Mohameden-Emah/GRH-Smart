package com.grh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grh.entites.Employee;
import com.grh.reposetory.EmployeeRepo;

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

    @Override
    public String updateEmp(Employee updatedEmployee, Long id) {
        Optional<Employee> existingEmployeeOptional = repository.findById(id);
    
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(updatedEmployee.getName());
            
    
            repository.save(existingEmployee);
            
            return "Employee est modified";
        } else {
            return "Employee not exist";
        }
    }


}
