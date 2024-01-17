package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TEST_EDIT")
@Setter
@Getter
public class TestEdit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testEdit_id")
    private Long id;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String rightAnswer;

//    @OneToOne(mappedBy = "testEdit")
    private Long lessonEditId;
}
