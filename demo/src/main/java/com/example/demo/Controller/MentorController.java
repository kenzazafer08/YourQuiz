package com.example.demo.Controller;

import com.example.demo.Entity.Mentor;
import com.example.demo.Service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/delete/{mentorCode}")
    public ResponseEntity<String> softDeleteMentor(@PathVariable String mentorCode) {
        boolean deleted = mentorService.softDeleteMentor(mentorCode);
        if(deleted){
            return ResponseEntity.ok("Mentor with code " + mentorCode + " is soft deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        List<Mentor> mentors = mentorService.getAllMentors();
        return ResponseEntity.ok(mentors);
    }


    @PutMapping("/update/{mentorCode}")
    public ResponseEntity<Optional<Mentor>> updateMentor(
            @PathVariable String mentorCode,
            @RequestBody Mentor updatedMentor
    ) {
        Optional<Mentor> updated = mentorService.updateMentor(mentorCode, updatedMentor);

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

