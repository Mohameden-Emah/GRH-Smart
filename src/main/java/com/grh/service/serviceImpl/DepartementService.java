package com.grh.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Optional<Departement> departementOptional = repository.findById(id);
        if(departementOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Departement> finAllDepartement(){
        return repository.findAll();
    }


    @Override
    public ResponseEntity<Object> getDepEmp(Long id) {
        Optional<Departement> dep = repository.findById(id);
        if(dep.isPresent()){

            var departement = dep.get();

            List<Employee> employeesInDepartment = empRepository.findByDepartement(departement);
            var depEmployees = new DepEmployees(employeesInDepartment.size(), employeesInDepartment);

            return ResponseEntity.ok().body(depEmployees);
            
        }else{
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dep not found");
        }
    }

}



