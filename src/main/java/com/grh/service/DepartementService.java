package com.grh.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grh.entites.Departement;
import com.grh.entites.Employee;
import com.grh.reposetory.DepartementRepo;
import com.grh.reposetory.EmployeeRepo;
import com.grh.service.employeBydep.DepEmployees;

@Service
public class DepartementService implements DepartementServiceln {

    @Autowired
    private DepartementRepo repository;
    @Autowired
    private EmployeeRepo empRepository;

    public Departement createDepartement (Departement departement){
        return repository.save(departement);
    }


    public Boolean deleteDepartement(Long id) {
        Optional<Departement> DepartementOptional = repository.findById(id);
        if(DepartementOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Departement> finAllDepartement(){
        return repository.findAll();
    }


    @Override
    public DepEmployees getDepEmp(Long id) {
        Optional<Departement> dep = repository.findById(id);
        System.out.println(dep);
        List<Employee> employees = empRepository.findAll();
        if(dep.isPresent()){
            Departement departement = dep.get();
            List<Employee> employeesInDepartment = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDepartement().equals(departement)) {
                    employeesInDepartment.add(employee);
                }
            }

            DepEmployees depEmp =  new DepEmployees();
            depEmp.setTotal(employeesInDepartment.size());
            depEmp.setEmp(employeesInDepartment);

            return depEmp;
            
        }else{
            return null;
        }
    }

    






}
