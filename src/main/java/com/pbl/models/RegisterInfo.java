package com.pbl.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "registerInfo")
@Data
public class RegisterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "date")
    public String date;
    @Column(name = "absence")
    public byte absence;
    @Column(name = "mark")
    public int mark;
    @Column(name = "activity")
    public String activity;

    @JsonBackReference
   /* @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
    /*@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "studentId", nullable = false)*/
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    public Student student;



}
