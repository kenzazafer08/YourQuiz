package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Question_Answer")
@Data
public class QuestionAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnoreProperties("questionAnswers")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    @JsonIgnoreProperties("questionAnswers")
    private Answers answer;

    private boolean correct;
}
