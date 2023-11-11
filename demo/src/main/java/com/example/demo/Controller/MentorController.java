package com.example.demo.Controller;

import com.example.demo.Entity.Mentor;
import com.example.demo.Service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mentors")
public class MentorController {

    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMentor(@RequestBody Mentor mentor) {
        mentorService.addMentor(mentor);
        return ResponseEntity.ok("Mentor added successfully");
    }

    @GetMapping("/{mentorCode}")
    public ResponseEntity<Mentor> getMentorByCode(@PathVariable String mentorCode) {
        Optional<Mentor> mentor = mentorService.findByCode(mentorCode);
        if (mentor.isPresent()) {
            return ResponseEntity.ok(mentor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

