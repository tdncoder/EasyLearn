package com.easy.learn.mapper;

import com.easy.learn.dto.FeedbackDTO;
import com.easy.learn.entity.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackMapper extends AbstractMapper<Feedback, FeedbackDTO> {
    public FeedbackMapper(){
        super(Feedback.class, FeedbackDTO.class);
    }
}
