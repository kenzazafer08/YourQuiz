package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "Subject")
@Data
@Getter
@Setter
@Where(clause = "deleted = false")
public class Subject {
    @Id
    private String code;
    private String title;
    @ManyToOne
    private Subject superSubject;

    @OneToMany(mappedBy = "superSubject")
    private List<Subject> subSubjects;
}
