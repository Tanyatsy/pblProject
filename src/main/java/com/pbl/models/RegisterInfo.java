package com.pbl.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "registerInfo")
@Data
public class RegisterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private String date;
    @Column(name = "absence")
    private byte absence;
    @Column(name = "mark")
    private int mark;
    @Column(name = "activity")
    private String activity;

    /*@JsonManagedReference*/
   /* @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
    /*@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "studentId", nullable = false)*/
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private Student student;

}
