package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "uuid", length = 5)
    private String uuid;
    @Column(name = "firstName", length = 30)
    private String firstName;
    @Column(name = "lastName", length =15)
    private String lastName;
    @Column(name = "email", length =100)
    private String email;
    @Column(name = "phone", length=10)
    private String phone;
    @Column(name = "age", length = 3)
    private Long age;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "status")
    private CustomerStatus status;
    @Column(name = "userName")
    private String userName;
}
