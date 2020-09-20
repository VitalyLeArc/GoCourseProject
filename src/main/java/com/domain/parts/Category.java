package com.domain.parts;


import java.util.Arrays;

public enum Category {
    LIGHT("Легковые", 1),
    MOTO("Мото", 2),
    WATER("Водный транспорт", 3),
    SPECIAL("Спецтехника", 4),
    TRAILER("Прицеп", 5),
    TRUCK("Грузовик", 6),
    BUS("Автобус", 7),
    AUTOHOUSE("Автодом", 8),
    AIR("Воздушный транспорт", 9),
    EMPTY("",00)
    ;

    private int value;
    private String name;

    Category(String name, int value) {
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
        return Arrays.stream(Category.values())
                .filter((p) -> p.getValue() == val).findFirst().orElse(Category.EMPTY).getName();
    }


}
