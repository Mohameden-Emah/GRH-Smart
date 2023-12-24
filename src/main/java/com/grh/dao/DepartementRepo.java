package com.grh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grh.entity.Departement;

@Repository
public interface DepartementRepo  extends JpaRepository<Departement,Long> {
}
