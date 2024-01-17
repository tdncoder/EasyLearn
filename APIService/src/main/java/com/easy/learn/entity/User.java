package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

}
