package com.example.demo.Controller;

import com.example.demo.Entity.Mentor;
import com.example.demo.Entity.Subject;
import com.example.demo.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSubject(@RequestBody Subject subject) {
        subjectService.addSubject(subject);
        return ResponseEntity.ok("Subject added successfully");
    }

    @GetMapping("/{subjectCode}")
    public ResponseEntity<Subject> getSubjectByCode(@PathVariable String subjectCode) {
        Optional<Subject> subject = subjectService.findByCode(subjectCode);
        if (subject.isPresent()) {
            return ResponseEntity.ok(subject.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
