package com.domain;

import com.domain.enums.AdvertBrand;
import com.domain.enums.AdvertType;
import com.domain.enums.AdvertVehicle;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="advert")
public class Advert {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="vehicle")
    @Enumerated(EnumType.STRING)
    private AdvertVehicle vehicle;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private AdvertType type;

    @Column(name="brand")
    @Enumerated(EnumType.STRING)
    private AdvertBrand brand;

    @Column(name="model")
    private String model;

}
