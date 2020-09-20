package com.domain.parts;

import java.util.Arrays;

public enum MotoBody {
    MOPED("Мопеды", 58),
    SCOOTER("Скутер / Мотороллер", 11),
    MAXI_SCOOTER("Макси-скутер", 12),
    MOTORCYCLE("Мотоциклы", 13),
    NAKED_BIKE("Мотоцикл Без обтекателей (Naked bike)", 15),
    ENDURO("Мотоцикл Внедорожный (Enduro)", 21),
    CUSTOM("Мотоцикл Кастом", 30),
    CLASSIC("Мотоцикл Классик", 14),
    CROSS("Мотоцикл Кросс", 19),
    CRUISER("Мотоцикл Круизер", 24),
    ALL_ROUND("Мотоцикл Многоцелевой (All-round)", 25),
    MOTO_WITH_SUB("Мотоцикл с коляской", 29),
    SPORT_BIKE("Спортбайк", 18),
    SPORT_TOURISM("Мотоцикл Спорт-туризм", 17),
    MOTARD("Мотоцикл Супермото (Motard)", 22),
    TRIAL("Мотоцикл Триал", 20),
    TOURISM("Мотоцикл Туризм", 16),
    CHOPPER("Мотоцикл Чоппер", 23),
    MINI_MOTO("Мини мотоциклы", 31),
    MINI_SPORT("Мини спорт", 32),
    PIT_BIKE("Мини крос (Питбайк)", 33),
    THREE_CYCLE("Трицикл", 34),
    TRIKE("Трайк", 57),
    QUADRO_CYCLE("Квадроциклы", 35),
    QUADRO_CHILD("Квадроцикл детский", 36),
    QUADRO_SPORT("Квадроцикл спортивный", 39),
    QUADRO_UTIL("Квадроцикл утилитарный", 41),
    ATV("Мотовездеход", 42),
    MOTO_AMPHIBIAN("Вездеход-амфибия", 43),
    GOLF_CAR("Гольф-кар", 44),
    СARTING("Картинг", 45),
    SNOW("Снегоход", 46),
    OTHER("Другое", 56),
    EMPTY("", 00)
    ;

    private int value;
    private String name;

    MotoBody(String name, int value) {
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
        return Arrays.stream(MotoBody.values())
                .filter((p) -> p.getValue() == val).findFirst().orElse(MotoBody.EMPTY).getName();
    }

}
