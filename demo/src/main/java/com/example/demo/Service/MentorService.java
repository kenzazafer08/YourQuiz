package com.example.demo.Service;

import com.example.demo.DAO.MentorDAO;
import com.example.demo.Entity.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorService {

    private final MentorDAO mentorDAO;

    @Autowired
    public MentorService(MentorDAO mentorDAO){
        this.mentorDAO = mentorDAO;
    }
    public Optional<Mentor> addMentor(Mentor mentor) {
        return Optional.of(mentorDAO.save(mentor));
    }

    public Optional<Mentor> findByCode(String mentorCode){
        Optional<Mentor> optionalMentor = mentorDAO.findById(mentorCode);
        return Optional.ofNullable(optionalMentor.orElse(null));
    }

    public boolean softDeleteMentor(String mentorCode) {
        Mentor mentor = mentorDAO.findById(mentorCode).orElse(null);
        if (mentor != null) {
            mentor.setDeleted(true);
            mentorDAO.save(mentor);
            return true;
        } else {
            return false;
        }
    }
}
