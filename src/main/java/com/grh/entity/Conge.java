package com.grh.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long congeID;

    private LocalDate dateStart;
    private LocalDate dateEnd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Employee employee;

}
