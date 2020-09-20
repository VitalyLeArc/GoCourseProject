package com.domain.parts;

import java.util.Arrays;

public enum CarBody {
    SEDAN( "Седан",3),
    CROSSOVER( "Внедорожник / Кроссовер",5),
    MINIVAN( "Минивэн",8),
    HATCHBACK( "Хэтчбек",4),
    UNIVERSAL( "Универсал",2),
    COUPE( "Купе",6),
    VAN( "Легковой фургон (до 1,5 т)",254),
    CABRIOLET( "Кабриолет",7),
    PICKUP( "Пикап",9),
    LIMOUSINE( "Лимузин",252),
    OTHER( "Другой",28),
    EMPTY("",-1)
    ;

    private String name;
    private int value;

    CarBody(String name, int value) {
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
        return Arrays.stream(CarBody.values())
                .filter((p) -> p.getValue() == val).findFirst().orElse(CarBody.EMPTY).getName();
    }

}
