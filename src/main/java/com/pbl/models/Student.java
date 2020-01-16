package com.pbl.models;


import lombok.Data;


import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private int studentId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "KPI")
    private String KPI;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Entity> tags;
}


