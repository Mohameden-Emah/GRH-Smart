package com.grh.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grh.entites.Conge;
import com.grh.entites.Employee;
import com.grh.reposetory.CongeRepo;
@Service
public class CongeService implements CongeServiceIn{

    @Autowired
    private CongeRepo repository;

    @Override
    public String createConge(Conge conge){
        boolean check = checkCongeThisYear(conge.getEmployee());
        if(check){
            return "Employee has take his LeaveRequest for this year";
        }else{
            repository.save(conge);
            return "Passed";
            
        }
        
    }

    @Override
    public Boolean deleteConge(Long id) {
        Optional<Conge> CongeOptional = repository.findById(id);
        if(CongeOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    
    

    @Override
    public String updateConge(Conge updatedConge, Long id) {

        Optional<Conge> existingCongeOptional = repository.findById(id);

        if (existingCongeOptional.isPresent()) {
            Conge existingConge = existingCongeOptional.get();
            existingConge.setDateStart(updatedConge.getDateStart());
            existingConge.setDateEnd(updatedConge.getDateEnd());

    
            repository.save(existingConge);
            
            return "Conge est modified";
        } else {
            return "Conge not exist";
        }
    }


    @Override
    public boolean checkCongeThisYear(Employee employee) {
        List<Conge> conges = repository.findAll();
        boolean emp =false;
        for (Conge conge : conges) {
            int ActualYear = LocalDate.now().getYear();
            if (conge.getEmployee() == employee && conge.getDateStart().getYear() == ActualYear) {
                emp = true;
            }
        }
        return emp;

    }

    @Override
    public List<Conge> finAllConge() {
        return repository.findAll();
    }

}
