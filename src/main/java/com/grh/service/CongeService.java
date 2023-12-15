package com.grh.service;

import com.grh.entites.Conge;
import com.grh.reposetory.CongeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CongeService {

    @Autowired
    private CongeRepo repository;

    public Conge createConge(Conge Conge){
        return repository.save(Conge);
    }


    public Boolean deleteConge(Long id) {
        Optional<Conge> CongeOptional = repository.findById(id);
        if(CongeOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }



    public List<Conge> finAllConge(){
        return repository.findAll();
    }

//    public String updateConge(Conge Conge, Long id){
//        Optional<Conge> CongeOptional=repository.findById(id);
//        if(CongeOptional.isPresent()){
//            Conge updateConge = CongeOptional.get();
//            updateConge.setName(Conge.getName());
//
//        }
//
//        return "";
//    }
}
