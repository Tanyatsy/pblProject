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
    private EntityId id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("studentId")
    private Student student;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("teacherId")
    private Teacher teacher;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("subjectId")
    private Subject subject;

    @Column
    private Date createdOn = new Date();


}


