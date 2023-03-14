package com.cadincloud.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "reviews")
public class ReviewEntity {

    @Id
    private String id;

    private String message;

    private int rating;

    private String touristName;

    private String roomId;
}
