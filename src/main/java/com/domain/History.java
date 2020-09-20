package com.domain;

import com.domain.parts.CarBody;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "vehicletype")
    private int body;

    @Column(name = "body")
    private int fuelType;

    @Column(name = "mark")
    private int mark;

    @Column(name = "fueltype")
    private int vehicleType;

    public boolean getShowSimilar(){
        return showSimilar;
    }
}
