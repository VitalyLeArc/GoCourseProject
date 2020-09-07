package com.domain;

import com.domain.enums.AdvertBrand;
import com.domain.enums.AdvertType;
import com.domain.enums.AdvertVehicle;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "showsimilar")
    private boolean showSimilar;

    @Column(name = "date")
    private LocalDateTime date;

    //копиписта полей из Advert. Надо унифицировать
    @Column(name = "vehicle")
    @Enumerated(EnumType.STRING)
    private AdvertVehicle vehicle;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AdvertType type;

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private AdvertBrand brand;

    @Column(name = "model")
    private String model;

}
