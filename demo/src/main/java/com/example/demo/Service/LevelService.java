package com.example.demo.Service;

import com.example.demo.DAO.LevelDAO;
import com.example.demo.Entity.Level;
import com.example.demo.Entity.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public boolean softDeleteLevel(String levelCode) {
        Level level = levelDAO.findById(levelCode).orElse(null);
        if (level != null) {
            level.setDeleted(true);
            levelDAO.save(level);
            return true;
        } else {
            return false;
        }
    }

    public List<Level> getAllLevels() {
        return levelDAO.findAll();
    }
}
