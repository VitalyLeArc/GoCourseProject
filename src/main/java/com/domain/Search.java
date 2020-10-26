package com.domain;

import com.domain.parts.CarBody;
import com.domain.parts.FuelType;
import com.domain.parts.Marks;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="history")
public class Search {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
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
    private LocalDate date;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (body != -1) {
            sb.append("Тип кузова: ");
            sb.append(CarBody.getNameByValue(body));
            sb.append(", топливо: ");
            sb.append(FuelType.getNameByValue(fuelType));
            sb.append(", марка: ");
            sb.append(Marks.getNameByValue(mark));
        }
        return sb.toString();
    }

    public boolean getShowSimilar(){
        return showSimilar;
    }
}
