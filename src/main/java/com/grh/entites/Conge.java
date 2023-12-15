package com.grh.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.grh.entites.Employee;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long congeID;

    private Date dateStart;
    private Date dateEnd;

    @ManyToOne(optional = false)
    private Employee employee;

}
