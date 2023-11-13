package com.example.demo.DAO;

import com.example.demo.Entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerDAO extends JpaRepository<Answers , String> {
    Optional<Answers> findByText(String text);
}
