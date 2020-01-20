package com.pbl.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    public int studentId;

    @Column(name = "firstName")
    public String firstName;

    @Column(name = "lastName")
    public String lastName;

    @Column(name = "KPI")
    public String KPI;

    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public List<Entity> tags;

    /*@JsonBackReference*/
   /* @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
    /*@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})*/
    @JsonManagedReference
    @OneToMany( fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "studentId")
    public Set<RegisterInfo> info;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getKPI() {
        return KPI;
    }

    public void setKPI(String KPI) {
        this.KPI = KPI;
    }

    public List<Entity> getTags() {
        return tags;
    }

    public void setTags(List<Entity> tags) {
        this.tags = tags;
    }

    public Set<RegisterInfo> getInfo() {
        return info;
    }

    public void setInfo(Set<RegisterInfo> info) {
        this.info = info;
    }
}


