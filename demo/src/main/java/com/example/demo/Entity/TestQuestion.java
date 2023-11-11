package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TestQuestion")
@Data
public class TestQuestion {
    @Id
    private Long id;
    private int time;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
