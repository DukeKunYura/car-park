package com.duke.carpark.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cars")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car {
    @Id
    @Column(name = "car_id")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "number")
    private String number;
    @Column(name = "vin")
    private String vin;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Detail> details = new ArrayList<>();

    public void addDetail(Detail detail) {
        details.add(detail);
        detail.setCar(this);
    }

    public void removeDetail(Detail detail) {
        details.remove(detail);
        detail.setCar(null);
    }
}
