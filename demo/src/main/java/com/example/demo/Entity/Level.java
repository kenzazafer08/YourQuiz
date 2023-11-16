package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "Level")
@Data
@Getter
@Setter
@Where(clause = "deleted = false")
public class Level {
    @Id
    private String code;
    private String description;
    private int minScore;
    private int maxScore;
    private Boolean deleted;
    @OneToMany(mappedBy = "level", fetch = FetchType.EAGER)
    private List<Question> questions;

}
