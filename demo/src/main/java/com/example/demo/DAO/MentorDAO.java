package com.example.demo.DAO;

import com.example.demo.Entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorDAO extends JpaRepository<Mentor , String> {
}
