package com.example.demo.DAO;

import com.example.demo.Entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDAO extends JpaRepository<Answers , String> {
}
