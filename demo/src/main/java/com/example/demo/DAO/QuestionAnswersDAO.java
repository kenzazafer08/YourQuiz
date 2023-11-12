package com.example.demo.DAO;

import com.example.demo.Entity.QuestionAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswersDAO extends JpaRepository<QuestionAnswers, String> {
}
