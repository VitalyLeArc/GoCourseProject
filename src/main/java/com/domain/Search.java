package com.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="history")
public class Search {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "body")
    private int body;

    @Column(name = "fueltype")
    private int fuelType;

    @Column(name = "mark")
    private int mark;

    @Column(name = "vehicletype")
    private int category;

    @Column(name ="showsimilar")
    private boolean showSimilar;

    @Column(name = "date")
    private LocalDateTime date;


}
