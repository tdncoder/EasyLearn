package com.easy.learn.service;

import com.easy.learn.dto.FeedbackDTO;

public interface FeedbackService extends BaseService<FeedbackDTO> {
    FeedbackDTO findByUuid(String uuid);
}
