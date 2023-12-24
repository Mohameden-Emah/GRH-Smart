package com.grh.service.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grh.dao.DepartementRepo;
import com.grh.dao.EmployeeRepo;
import com.grh.dto.DepEmployees;
import com.grh.entity.Departement;
import com.grh.entity.Employee;
import com.grh.service.DepartementServiceln;

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
