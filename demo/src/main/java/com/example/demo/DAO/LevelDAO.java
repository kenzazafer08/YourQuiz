package com.example.demo.DAO;

import com.example.demo.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelDAO extends JpaRepository<Level , String> {
}
