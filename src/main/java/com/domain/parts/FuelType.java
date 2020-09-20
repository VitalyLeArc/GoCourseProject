package com.domain.parts;

import java.util.Arrays;

public enum FuelType {
    GASOLINE("Бензин", 1),
    DISEL("Дизель", 2),
    GAS("Газ", 3),
    GAS_GASOLINE("Газ/бензин", 4),
    HYBRID("Гибрид", 5),
    ELECTRO("Электро", 6),
    OTHER("Другое", 7),
    GAS_METHANE("Газ метан", 8),
    GAS_PROPANE("Газ пропан-бутан", 9),
    EMPTY("", -1)
    ;

    private int value;
    private String name;

    FuelType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameByValue(int val) {
        return Arrays.stream(FuelType.values())
                .filter((p) -> p.getValue() == val).findFirst().orElse(FuelType.EMPTY).getName();
    }
}

