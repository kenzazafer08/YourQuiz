package com.example.demo.Controller;

import com.example.demo.Entity.Level;
import com.example.demo.Entity.Mentor;
import com.example.demo.Service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/levels")
public class LevelController {

    private final LevelService levelService;

    @Autowired
    public LevelController(LevelService levelService){
        this.levelService = levelService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLevel(@RequestBody Level level) {
        levelService.addLevel(level);
        return ResponseEntity.ok("Level added successfully");
    }
}
