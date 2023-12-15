package com.grh.service;

import com.grh.entites.Conge;

import java.util.List;

public interface CongeServiceIn {
    public Conge createConge(Conge Conge);
    public List<Conge> finAllConge();
    public String updateConge(Conge Conge, Long id);
    public Boolean deleteConge(Long id);

}
