package com.odde.bbuddy.charter.repo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "car_configs")
public class CarConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int carFee;
    private int serviceFee;

    private int driveAloneFee;
}
