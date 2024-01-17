package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ADMIN_TRAINER")
@Setter
@Getter
public class AdminTrainer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //random uuid
    @Type(type="uuid-char")
    private UUID uuid = UUID.randomUUID();

    @Column(length = 30)
    private String firstName;
    @Column(length = 15)
    private String lastName;
    private String country;

    private Boolean status;
    private LocalDate dob;
    private String email;

    private Boolean gender;
    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 16)
    private String cardNumber;

//    @OneToMany(mappedBy = "adminTrainer", cascade = CascadeType.ALL)
//    private Set<CourseEdit> courseEdits = new HashSet<>();
    private String courseList;


}
