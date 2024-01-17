package com.easy.learn.dto.TrainerSalaryPaid;

import lombok.Data;

@Data
public class ResponseMessage {
    private String status;
    private String message;

    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters
    // ...
}