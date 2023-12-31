package com.example.demo.DAO;

import com.example.demo.Entity.QuestionAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionAnswersDAO extends JpaRepository<QuestionAnswers, String> {
    Optional<QuestionAnswers> findByQuestion_CodeAndAnswer_Code(String questionCode, String answerCode);
}
