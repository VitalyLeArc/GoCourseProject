package com.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Vehicle {

    private LocalDate addDate;

    private int costUsd;

    private String locationCityName;

    private String markName;

    private String modelName;

}
