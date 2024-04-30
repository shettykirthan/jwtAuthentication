package com.Chatbot.SBERT.controller;

import com.Chatbot.SBERT.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PredictionController {

    private final QuestionService questionService;

    @Autowired
    public PredictionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/predict")
    public Mono<String> predict(@RequestBody String question) {
        return questionService.predictUsingFastAPI(question);
    }
}
