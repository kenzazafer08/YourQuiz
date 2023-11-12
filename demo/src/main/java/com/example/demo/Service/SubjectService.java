package com.example.demo.Service;

import com.example.demo.DAO.SubjectDAO;
import com.example.demo.Entity.Mentor;
import com.example.demo.Entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public boolean softDeleteSubject(String subjectCode) {
        Subject subject = subjectDAO.findById(subjectCode).orElse(null);
        if (subject != null) {
            subject.setDeleted(true);
            subjectDAO.save(subject);
            return true;
        } else {
            return false;
        }
    }

    public List<Subject> getAllSubjects() {
        return subjectDAO.findAll();
    }

    public Optional<Subject> updateMentor(String subjectCode, Subject updatedSubject) {
        Subject existingSubject = subjectDAO.findById(subjectCode).orElse(null);

        if (existingSubject != null) {
            existingSubject.setTitle(updatedSubject.getTitle());
            existingSubject.setSuperSubject(updatedSubject.getSuperSubject());

            return Optional.of(subjectDAO.save(existingSubject));
        }

        return Optional.empty();
    }

}
