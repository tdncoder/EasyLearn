package com.easy.learn.web.dto.trainer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer implements Serializable {
    private Long id;
    private String uuid;
    private String email;
    private String phone;
}
