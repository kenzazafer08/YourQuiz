package com.example.demo.DAO;

import com.example.demo.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends JpaRepository<Question, String> {
}
