package com.grh.reposetory;

import com.grh.entites.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepo  extends JpaRepository<Departement,Long> {
}
