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
@Table(name = "Answer")
@Data
@Getter
@Setter
@Where(clause = "deleted = false")
public class Answers {
    @Id
    private String code;
    private String text;
    private boolean deleted;

    @OneToMany(mappedBy = "answer")
    private List<QuestionAnswers> questionAnswers;
}
