package com.grh.entites;

import jakarta.persistence.*;
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
 private Long id;
    @Column(nullable = false, name= "name")
 private String Name_dep ;
    @Column(nullable = false)
 private String desc_dep;

}
