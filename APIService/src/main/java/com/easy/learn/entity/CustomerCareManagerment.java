package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customerCareManagement")
public class CustomerCareManagerment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "firstName", length = 30)
    private String firstName;
    @Column(name = "lastName", length =15)
    private String lastName;
    @Column(name = "email", length = 100)
    private String emailAddress;
    @Column(name = "phone", length = 10)
    private String phoneNumber;
    @Column(name = "age" , length = 3)
    private Integer age;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "adminId")
    private Integer adminId;

}
