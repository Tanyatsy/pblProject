package com.pbl.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "entityTag")
@Data
@NaturalIdCache
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Entity {

    @EmbeddedId
    public EntityId id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("studentId")
    public Student student;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("teacherId")
    public Teacher teacher;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("subjectId")
    public Subject subject;

    @Column
    public Date createdOn = new Date();


}


