package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

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
    protected Boolean deleted;
}
