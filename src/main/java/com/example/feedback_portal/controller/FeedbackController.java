package com.example.feedback_portal.controller;

import com.example.feedback_portal.entity.Feedback;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    List<Feedback> feedbackList = new ArrayList<>();


    public FeedbackController() {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("feedback.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    Feedback feedback = new Feedback();

                    feedback.setStudentName(data[0]);
                    feedback.setDepartment(data[1]);
                    feedback.setRating(data[2]);
                    feedback.setMessage(data[3]);

                    feedbackList.add(feedback);
                }
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("No existing feedback found.");
        }
    }


    @PostMapping("/submit")
    public String submitFeedback(@RequestBody Feedback feedback) {

        feedbackList.add(feedback);

        try {

            FileWriter writer = new FileWriter("feedback.txt", true);

            writer.write(
                    feedback.getStudentName() + "|" +
                            feedback.getDepartment() + "|" +
                            feedback.getRating() + "|" +
                            feedback.getMessage() + "\n"
            );

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return "Feedback Submitted Successfully";
    }


    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {

        return feedbackList;
    }

    @GetMapping("/clear")
    public String clearFeedback() {

        feedbackList.clear();

        try {

            FileWriter writer = new FileWriter("feedback.txt");

            writer.write("");

            writer.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "All Feedback Deleted Successfully";
    }
}