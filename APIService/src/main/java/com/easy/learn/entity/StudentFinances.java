package com.easy.learn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STUDENT_FINANCES")
@Getter
@Setter
public class StudentFinances extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "DATA_RECORDED")
    private String dataRecorded;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "PAYMENT_METHOD")
    private boolean paymentMethod;

    @Column(name = "DESCRIPTION")
    private boolean description;

    @Column(name = "CREDIT_DEBIT_CARD")
    private boolean creditDebit;

    @Column(name = "STATUS")
    private boolean status;
}
