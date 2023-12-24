package com.grh.service;

import java.util.List;

import com.grh.entity.Conge;

public interface CongeServiceIn {
    public String createConge(Conge conge);
    public List<Conge> finAllConge();
    public String updateConge(Conge conge, Long id);
    public Boolean deleteConge(Long id);
    public boolean checkCongeThisYear(Long id);

}
