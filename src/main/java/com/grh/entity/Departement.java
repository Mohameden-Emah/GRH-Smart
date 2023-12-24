package com.grh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Departement {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long idDep;
   @Column(nullable = false, name= "name")
   private String Name_dep ;
   @Column(nullable = false)
   private String desc_dep;

}
