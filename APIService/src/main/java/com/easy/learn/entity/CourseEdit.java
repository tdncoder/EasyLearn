package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COURSE_EDIT")
@Setter
@Getter
public class CourseEdit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_id")
    private Long id;

    private LocalDateTime lastUpdate;

    private Boolean status;

    @Column(length = 50)
    private String title;

    @Column(length = 250)
    private String description;

    private String img;


//    @ManyToOne
//    @JoinColumn(name = "AdminTrainer_id")
    private Long adminTrainerId;

//    @OneToMany(mappedBy = "courseEdit",cascade = CascadeType.ALL)
//    private Set<LessonEdit> lessonEdits = new HashSet<>();
    private String lessonList;



}
