package com.easy.learn.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public Page<T> pages;
}
