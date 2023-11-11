package com.example.demo.Service;

import com.example.demo.DAO.LevelDAO;
import com.example.demo.Entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LevelService {

    private final LevelDAO levelDAO;

    @Autowired
    public LevelService(LevelDAO levelDAO){
        this.levelDAO = levelDAO;
    }

    public Optional<Level> addLevel(Level level){
        return Optional.of(levelDAO.save(level));
    }
}
