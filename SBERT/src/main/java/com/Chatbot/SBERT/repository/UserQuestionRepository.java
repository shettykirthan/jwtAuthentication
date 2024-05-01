package com.Chatbot.SBERT.repository;


import com.Chatbot.SBERT.model.Question;
import com.Chatbot.SBERT.model.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionRepository extends JpaRepository<UserQuestion, Long> {
}