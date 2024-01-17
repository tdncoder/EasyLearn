package com.easy.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supportRequests")
public class SupportRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "uuid", length = 5)
    private Long uuid;
    @Column(name = "requestDate")
    private Date requestDate;
    @Column(name = "supportRequestStatus")
    private SupportRequestsStatus status;
    @Column(name = "amount" )
    private Integer amount;
    @Column(name = "transactionDate")
    private Date transactionDate;
    @Column(name = "description", length = 200)
    private String description;
    @Column(name = "customerId", length = 5)
    private Long customerId;
    @Column(name = "customerCareManagermentId", length = 5)
    private Long customerCareManagermentId;

}
