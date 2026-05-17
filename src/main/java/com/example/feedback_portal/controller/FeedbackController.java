package com.example.feedback_portal.controller;

import com.example.feedback_portal.entity.Feedback;
import com.example.feedback_portal.repository.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    @Autowired
    private FeedbackRepository repository;


    @PostMapping("/feedback")
    public Feedback saveFeedback(@RequestBody Feedback feedback){

        return repository.save(feedback);
    }


    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback(){

        return repository.findAll();
    }

}