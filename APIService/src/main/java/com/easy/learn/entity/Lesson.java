package com.easy.learn.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Lesson")
@Getter
@Setter
public class Lesson extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String duration;
    private String url;


    private Long courseId;


}
