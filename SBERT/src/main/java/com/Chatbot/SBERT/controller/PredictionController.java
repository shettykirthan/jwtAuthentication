package com.Chatbot.SBERT.controller;

import com.Chatbot.SBERT.model.UserQuestion;
import com.Chatbot.SBERT.repository.UserQuestionRepository;
import com.Chatbot.SBERT.service.imp.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PredictionController {

    private final QuestionService questionService;
    private final UserQuestionRepository userQuestionRepository;

    @Autowired
    public PredictionController(QuestionService questionService, UserQuestionRepository userQuestionRepository) {
        this.questionService = questionService;
        this.userQuestionRepository = userQuestionRepository;
    }

    @PostMapping("/predict")
    public Mono<String> predict(@RequestBody String question) {
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setQuestion(question);
        userQuestionRepository.save(userQuestion);
        return questionService.predictUsingFastAPI(question);
    }
}