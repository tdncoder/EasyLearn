package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.mapstruct.Named;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
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
    @Column(name="dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "phone", length = 10)
    private String phone;
    @Column(name="classId")
    private String classId;
    @Column(name = "memberManagermentId")
    private Long memberManagermentId;
}
