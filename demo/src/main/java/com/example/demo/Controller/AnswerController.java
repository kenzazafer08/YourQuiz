package com.example.demo.Controller;

import com.example.demo.Entity.Answers;
import com.example.demo.Entity.Level;
import com.example.demo.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{answerCode}")
    public ResponseEntity<Answers> findAnswerByCode(@PathVariable String answerCode){
        Optional<Answers> answer = answerService.findByCode(answerCode);
        if(answer.isPresent()){
            return ResponseEntity.ok(answer.get());
        }
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/delete/{answerCode}")
    public ResponseEntity<String> softDeleteAnswer(@PathVariable String answerCode) {
        boolean deleted = answerService.softDeleteAnswer(answerCode);
        if(deleted){
            return ResponseEntity.ok("Answer with code " + answerCode + " is soft deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Answers>> getAllAnswers() {
        List<Answers> answers = answerService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }
}
