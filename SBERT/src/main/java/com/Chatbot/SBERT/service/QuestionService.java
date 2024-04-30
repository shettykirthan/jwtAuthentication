package com.Chatbot.SBERT.service;

import com.Chatbot.SBERT.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class QuestionService {

    private final WebClient webClient;

    @Autowired
    public QuestionService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> predictUsingFastAPI(String question) {
        return webClient.post()
                .uri("http://localhost:8000/predict") // Adjust the URI as needed
                .body(BodyInserters.fromValue(new Question(question))) // Use BodyInserters.fromValue for proper serialization
                .retrieve()
                .bodyToMono(String.class);
    }
}
