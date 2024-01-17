package com.easy.learn.service.Impl;

import com.easy.learn.dto.FeedbackDTO;
import com.easy.learn.dto.ManagerDTO;
import com.easy.learn.dto.StudentDTO;
import com.easy.learn.entity.Feedback;
import com.easy.learn.entity.Manager;
import com.easy.learn.entity.Student;
import com.easy.learn.mapper.FeedbackMapper;
import com.easy.learn.mapper.StudentMapper;
import com.easy.learn.repository.FeedbackRepository;
import com.easy.learn.repository.StudentRepository;
import com.easy.learn.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository repository;
    @Autowired
    FeedbackMapper mapper;

    @Override
    public FeedbackDTO create(FeedbackDTO dto) {
        FeedbackDTO result = new FeedbackDTO();
        try {
            Feedback feedback = mapper.convertDTOToEntity(dto);
            result =mapper.convertEntityToDTO(repository.saveAndFlush(feedback));
        } catch (Exception ex) {
            log.error("Error when creating:", ex);
        }

        return result;
    }

    @Override
    public boolean update(FeedbackDTO dto) {
        try {
            Feedback feedback = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(feedback));
            return true;
        } catch (Exception ex) {
            log.error("Error when updating:", ex);
            return false;
        }
    }

    @Override
    public List<FeedbackDTO> findAll() {
        List<Feedback> feedbacks = repository.findAll();
        return feedbacks == null ? new ArrayList<>()
                : feedbacks.stream().map(entity -> mapper.convertEntityToDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        Feedback feedback = repository.findById(id).get();
        if (feedback != null) {
            repository.delete(feedback);
            return true;
        }
        return false;
    }
    @Override
    public FeedbackDTO findByUuid(String uuid) {
        Feedback feedback = repository.findByUuid(uuid);
        return feedback != null ? mapper.convertEntityToDTO(feedback) : null;
    }
}
