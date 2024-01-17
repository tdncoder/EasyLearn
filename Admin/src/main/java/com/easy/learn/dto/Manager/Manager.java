package com.easy.learn.dto.Manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private Long id;
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String managementtype;
}
