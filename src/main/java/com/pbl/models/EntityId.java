package com.pbl.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Data
public class EntityId implements Serializable {

    @Column(name = "studentId")
    private int studentId;

    @Column(name = "subjectId")
    private int subjectId;

    @Column(name = "teacherId")
    private int teacherId;



}
