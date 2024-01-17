package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "memberManagerment")
public class MemberManagerment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "uuid", length = 5)
    private String uuid;
    @Column(name = "firstName", length = 30)
    private String firstName;
    @Column(name = "lastName", length = 15)
    private String lastName;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "age",length = 3)
    private Integer age;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "email",length = 25)
    private String email;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "phoneNumber" , length = 10)
    private Integer phoneNumber;
    @Column(name = "adminId")
    private Integer adminId;
}
