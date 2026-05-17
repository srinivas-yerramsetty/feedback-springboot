package com.example.feedback_portal.controller;

import com.example.feedback_portal.entity.Feedback;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    List<Feedback> feedbackList = new ArrayList<>();

    @PostMapping("/submit")
    public String submitFeedback(@RequestBody Feedback feedback){

        feedbackList.add(feedback);

        return "Feedback Submitted Successfully";
    }

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback(){

        return feedbackList;
    }
}