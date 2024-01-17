package com.easy.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO<T> implements Serializable {
    public String message;
    @JsonProperty("error_code")
    public Integer errorCode;
    public T data;
    public List<T> list;
}