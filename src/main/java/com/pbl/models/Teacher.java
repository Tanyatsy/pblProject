package com.pbl.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherId")
    private int teacherId;

    @Column(name = "teacherName")
    private String teacherName;

    @OneToMany(mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Entity> tags;

}
