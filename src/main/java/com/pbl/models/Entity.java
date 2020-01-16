package com.pbl.models;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teacherId")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subjectId")
    private Subject subject;

    @Column
    private Date createdOn = new Date();


}


