package com.Chatbot.SBERT.controller;

import com.Chatbot.SBERT.model.UserQuestion;
import com.Chatbot.SBERT.repository.UserQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserQuestionRepository userQuestionRepository;

    @GetMapping("/questions")
    public List<UserQuestion> getAllUserQuestions() {
        return userQuestionRepository.findAll();
    }
}