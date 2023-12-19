package com.grh.reposetory;

import com.grh.entites.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongeRepo extends JpaRepository<Conge,Long> {
    public List<Conge> findByEmployeIdAndDateCongeYear(Long employeId, int year);
}
