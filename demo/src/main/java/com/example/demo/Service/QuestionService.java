package com.example.demo.Service;

import com.example.demo.DAO.QuestionAnswersDAO;
import com.example.demo.Entity.Question;
import com.example.demo.Entity.QuestionAnswers;
import com.example.demo.DAO.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionDAO questionRepository;
    private final QuestionAnswersDAO questionAnswersDAO;

    @Autowired
    public QuestionService(QuestionDAO questionRepository , QuestionAnswersDAO questionAnswersDAO) {
        this.questionRepository = questionRepository;
        this.questionAnswersDAO = questionAnswersDAO;
    }

    public Optional<Question> addQuestion(Question question) {
        return Optional.of(questionRepository.save(question));
    }

    @Transactional
    public List<QuestionAnswers> addAnswersToQuestion(String questionCode, List<QuestionAnswers> answers) {
        Optional<Question> question = questionRepository.findById(questionCode);
        if (question.isEmpty()) {
            return null;
        }

        List<QuestionAnswers> existingAnswers = question.get().getQuestionAnswers();

        int maxAnswersAllowed = question.get().getNbrAnswers();

        if (existingAnswers.size() >= maxAnswersAllowed) {
            return null;
        }

        int answersToAdd = maxAnswersAllowed - existingAnswers.size();
        List<QuestionAnswers> newAnswers = new ArrayList<>();

        for (int i = 0; i < answersToAdd && i < answers.size(); i++) {
            QuestionAnswers qa = new QuestionAnswers();
            qa.setQuestion(question.get());
            qa.setAnswer(answers.get(i).getAnswer());
            qa.setCorrect(answers.get(i).isCorrect());
            newAnswers.add(qa);
        }
        questionAnswersDAO.saveAll(newAnswers);
        return newAnswers;
    }

    public Optional<Question> findByCode(String answerCode){
        Optional<Question> optionalQuestion = questionRepository.findById(answerCode);
        return Optional.ofNullable(optionalQuestion.orElse(null));
    }

    public boolean softDeleteQuestion(String subjectCode) {
        Question question = questionRepository.findById(subjectCode).orElse(null);
        if (question != null) {
            question.setDeleted(true);
            questionRepository.save(question);
            return true;
        } else {
            return false;
        }
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


}
