package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@MappedSuperclass
public class Person {

    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String address;
    protected Boolean deleted;
}

