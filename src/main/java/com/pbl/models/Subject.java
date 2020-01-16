package com.pbl.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Data
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectId")
    private int subjectId;

    @Column(name = "subjectName")
    private String subjectName;

    @Column(name = "nrOfLessons")
    private int nrOfLessons;

    @OneToMany(mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Entity> tags;
}
