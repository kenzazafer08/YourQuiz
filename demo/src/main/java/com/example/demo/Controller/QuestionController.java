package com.example.demo.Controller;

import com.example.demo.Entity.Question;
import com.example.demo.Entity.QuestionAnswers;
import com.example.demo.Entity.Subject;
import com.example.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Optional<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PostMapping("/{questionCode}/answers")
    public List<QuestionAnswers> addAnswersToQuestion(
            @PathVariable String questionCode,
            @RequestBody List<QuestionAnswers> answer
    ) {
        return questionService.addAnswersToQuestion(questionCode, answer);
    }

    @GetMapping("/{questionCode}")
    public ResponseEntity<Question> getSubjectByCode(@PathVariable String questionCode) {
        Optional<Question> question = questionService.findByCode(questionCode);
        if (question.isPresent()) {
            return ResponseEntity.ok(question.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/delete/{questionCode}")
    public ResponseEntity<String> softDeleteSubject(@PathVariable String questionCode) {
        boolean deleted = questionService.softDeleteQuestion(questionCode);
        if(deleted){
            return ResponseEntity.ok("Question with code " + questionCode + " is soft deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
