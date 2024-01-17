package com.easy.learn.mapper;

import com.easy.learn.dto.TestEditDTO;
import com.easy.learn.entity.TestEdit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestEditMapper extends AbstractMapper<TestEdit, TestEditDTO>{
    public TestEditMapper(){
        super(TestEdit.class,TestEditDTO.class);
    }

    public List<TestEditDTO> convertEntityListToDTOList(List<TestEdit> entities) {
        return entities.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<TestEdit> convertDTOListToEntityList(List<TestEditDTO> dtos) {
        return dtos.stream()
                .map(this::convertDTOToEntity)
                .collect(Collectors.toList());
    }
}
