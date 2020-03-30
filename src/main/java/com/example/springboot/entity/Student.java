package com.example.springboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@NoArgsConstructor
@Data

public class Student {
    @Id
    private int id;
    private String name;
    private boolean Root;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "student")
    private List<Elective> electives;
    @OneToMany(mappedBy = "student")
    private List<DirectionElective> directionElectives;


}
