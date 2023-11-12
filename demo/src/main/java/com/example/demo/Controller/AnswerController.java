package com.example.demo.Controller;

import com.example.demo.Entity.Answers;
import com.example.demo.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService){
        this.answerService = answerService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAnswer(@RequestBody Answers answer) {
        answerService.addAnswer(answer);
        return ResponseEntity.ok("Answer added successfully");
    }
}
