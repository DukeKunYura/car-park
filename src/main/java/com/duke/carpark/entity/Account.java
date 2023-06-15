package com.duke.carpark.entity;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {
    @Id
    @Column(name = "account_id")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "number")
    private String number;
    @Column(name = "title")
    private String title;
    @Column(name = "score")
    private BigDecimal score;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
