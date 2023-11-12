package com.example.demo.DAO;

import com.example.demo.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDAO extends JpaRepository<Subject , String> {
}
