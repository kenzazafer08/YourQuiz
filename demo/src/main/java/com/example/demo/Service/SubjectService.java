package com.example.demo.Service;

import com.example.demo.DAO.SubjectDAO;
import com.example.demo.Entity.Level;
import com.example.demo.Entity.Mentor;
import com.example.demo.Entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectDAO subjectDAO;

    @Autowired
    public SubjectService(SubjectDAO subjectDAO){
        this.subjectDAO = subjectDAO;
    }

    public Optional<Subject> addSubject(Subject subject){
        return Optional.of(subjectDAO.save(subject));
    }

    public Optional<Subject> findByCode(String SubjectCode){
        Optional<Subject> optionalSubject = subjectDAO.findById(SubjectCode);
        return Optional.ofNullable(optionalSubject.orElse(null));
    }
}
