package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Mentor")
@Data
@Getter
@Setter
@Where(clause = "deleted = false")
public class Mentor extends Person{
    @Id
    private String Number;
    private String speciality;
}
