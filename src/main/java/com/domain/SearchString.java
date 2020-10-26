package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class SearchString {

    private Long id;

    private Long userId;

    private String body;

    private String fuelType;

    private String mark;

    private String category;

    private boolean showSimilar;

    private String date;

    public String getCategory() {
        return category;
    }
}
