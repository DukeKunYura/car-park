package com.duke.carpark.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "details")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Detail {
    @Id
    @Column(name = "detail_id")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
