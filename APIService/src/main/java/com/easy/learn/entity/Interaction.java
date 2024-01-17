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
@Table(name = "interaction")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "uuid", length = 5)
    private String uuid;
    @Column(name = "interactionDate")
    private Date interactionDate;
    @Column(name = "type")
    private InteractionType type;
    @Column(name = "note", length = 100)
    private String note;
    @Column(name = "customerId", length = 5)
    private Long customerId;
    @Column(name = "customerCareManagerId", length = 5)
    private Long customerCareManagermentId;
}
