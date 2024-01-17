package com.easy.learn.web.dto.user;

import com.easy.learn.web.dto.ReponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO extends ReponseDTO<User> {

    private Long id;
    private String uuid;
    private String username;
    private String password;
    public List<User> getList() {
        return null;
    }
}
