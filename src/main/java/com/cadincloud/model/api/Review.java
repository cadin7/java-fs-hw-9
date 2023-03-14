package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Review {

    private String id;

    private String message;

    private int rating;

    private String touristName;

    private String roomId;
}

