package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private boolean deleted;
    @ManyToOne
    private Subject superSubject;

    @OneToMany(mappedBy = "superSubject")
    @JsonManagedReference
    private List<Subject> subSubjects;
}
