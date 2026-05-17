package com.example.feedback_portal.repository;

import com.example.feedback_portal.entity.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}