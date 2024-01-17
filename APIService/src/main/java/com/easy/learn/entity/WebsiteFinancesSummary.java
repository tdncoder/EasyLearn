package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "WEBSITE_FINANCES_SUMMARY")
@Getter
@Setter
public class WebsiteFinancesSummary extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "MONTH_NUMBER")
    private Integer monthNumber;

    @Column(name = "YEAR_NUMBER")
    private Integer yearNumber;

    @Column(name = "TOTAL_NUMBER")
    private Double totalNumber;
}
