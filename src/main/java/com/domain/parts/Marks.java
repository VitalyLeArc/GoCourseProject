package com.domain.parts;

import java.util.Arrays;

public enum Marks {
    ACURA("Acura", 98),
    ADLER("Adler", 2396),
    AIXAM("Aixam", 2),
    ALFA_ROMEO("Alfa Romeo", 3),
    ALPINE("Alpine", 100),
    ALTAMAREA("Altamarea", 3988),
    ARO("Aro", 101),
    ARTEGA("Artega", 3105),
    ASIA("Asia", 4),
    ASTON_MARTIN("Aston Martin", 5),
    AUDI("Audi", 6),
    AUSTIN("Austin", 7),
    AUTOBIANCHI("Autobianchi", 102),
    EMPTY("", -1)
    ;

    private int value;
    private String name;

    Marks(String name, int value) {
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
        return Arrays.stream(Marks.values())
                .filter((p) -> p.getValue() == val).findFirst().orElse(Marks.EMPTY).getName();
    }


}
