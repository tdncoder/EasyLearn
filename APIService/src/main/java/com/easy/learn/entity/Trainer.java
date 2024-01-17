package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.ColumnDefault;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "uuid", length = 5)
    private String uuid;
    @Column(name = "firstname", length = 30)
    private String firstname;
    @Column(name = "lastname", length = 15)
    private String lastname;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "address", length = 10)
    private String phone;
    @Column(name = "datecreated")
    private Date datecreated;
    @Column(name = "status")
    private String status;
}
