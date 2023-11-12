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
@Table(name = "Question")
@Data
@Getter
@Setter
@Where(clause = "deleted = false")
public class Question {
    @Id
    private String code;
    private int nbrAnswers;
    private int rightAnswers;
    private String text;
    private int MaxScore;
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "question")
    private List<QuestionAnswers> questionAnswers;
}
