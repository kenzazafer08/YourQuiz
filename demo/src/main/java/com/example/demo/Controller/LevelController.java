package com.example.demo.Controller;

import com.example.demo.Entity.Level;
import com.example.demo.Entity.Mentor;
import com.example.demo.Service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/delete/{levelCode}")
    public ResponseEntity<String> softDeleteLevel(@PathVariable String levelCode) {
        boolean deleted = levelService.softDeleteLevel(levelCode);
        if(deleted){
            return ResponseEntity.ok("Level with code " + levelCode + " is soft deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
