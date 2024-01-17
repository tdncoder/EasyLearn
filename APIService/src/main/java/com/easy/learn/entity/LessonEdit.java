package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LESSON_EDIT")
@Setter
@Getter
public class LessonEdit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Lesson_id")
    private Long id;

    private Long number;
    @Column(length = 60)
    private String title;

    private LocalDateTime lastUpdate;

    private String video;
    private String test;

    private Integer duration;

//    @ManyToOne
//    @JoinColumn(name = "Course_id")
    private Long courseEditId;

//    @OneToOne
//    @JoinColumn(name = "testEdit_id")
    private Long testEditId;

}



