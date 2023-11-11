package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "Answer")
@Data
@Getter
@Setter
@Where(clause = "deleted = false")
public class Answers {
    @Id
    private String code;
    private String text;

    @OneToMany(mappedBy = "answer")
    private List<QuestionAnswers> questionAnswers;
}
