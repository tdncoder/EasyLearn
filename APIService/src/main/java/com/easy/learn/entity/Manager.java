package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "uuid", length = 5)
    private String uuid;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "managementType")
    private String managementtype;

    public Manager(String uuid, String firstname, String lastname, String username, String email, String address, String phone, String password, String managementType) {
        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.managementtype = managementType;
    }

}
