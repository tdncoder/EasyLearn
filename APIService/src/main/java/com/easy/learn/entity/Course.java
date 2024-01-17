package com.easy.learn.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "course")
@Getter
@Setter

public class Course extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "total_video")
    private Integer totalVideo;
    @Column(name = "level")
    private String level;
    @Column(name = "rating")
    private Double rating;
}
