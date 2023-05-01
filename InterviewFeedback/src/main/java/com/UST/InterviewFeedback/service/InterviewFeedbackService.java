package com.UST.InterviewFeedback.service;

import com.UST.InterviewFeedback.entity.InterviewFeedback;

import java.util.Optional;

public interface InterviewFeedbackService extends GenericService<InterviewFeedback,Long> {
    void deleteById(long id);

    Optional<InterviewFeedback> findById(long id);
}