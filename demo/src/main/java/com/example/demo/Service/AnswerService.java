package com.example.demo.Service;

import com.example.demo.DAO.AnswerDAO;
import com.example.demo.Entity.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO){
        this.answerDAO = answerDAO;
    }

    public Optional<Answers> addAnswer(Answers answer){
        Optional<Answers> existingAnswer = answerDAO.findByText(answer.getText());

        if (existingAnswer.isPresent()) {
            return Optional.empty();
        } else {
            return Optional.of(answerDAO.save(answer));
        }
    }

    public Optional<Answers> findByCode(String answerCode){
        Optional<Answers> optionalAnswers = answerDAO.findById(answerCode);
        return Optional.ofNullable(optionalAnswers.orElse(null));
    }

    public boolean softDeleteAnswer(String answerCode) {
        Answers answer = answerDAO.findById(answerCode).orElse(null);
        if (answer != null) {
            answer.setDeleted(true);
            answerDAO.save(answer);
            return true;
        } else {
            return false;
        }
    }

    public List<Answers> getAllAnswers() {
        return answerDAO.findAll();
    }

    public Optional<Answers> updateAnswer(String answerCode, Answers updatedAnswer) {
        Answers existingAnswer = answerDAO.findById(answerCode).orElse(null);

        if (existingAnswer != null) {
            existingAnswer.setText(updatedAnswer.getText());

            return Optional.of(answerDAO.save(existingAnswer));
        }

        return Optional.empty();
    }

}
