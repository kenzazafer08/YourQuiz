package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Test")
@Data
public class Test {
    @Id
    private String code;
    private int successScore;
    private boolean viewAnswersAllowed;
    private boolean viewResultAtEnd;
    private int numberOfTries;
    private String remarks;
    private String instructions;
    private boolean timed;

    @ManyToOne
    @JoinColumn(name = "Mentor_id")
    private Mentor trainer;

    @OneToMany(mappedBy = "test")
    private List<TestQuestion> testQuestions;
}
