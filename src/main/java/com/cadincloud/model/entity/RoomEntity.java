package com.cadincloud.model.entity;

import com.cadincloud.model.api.RoomFacilities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "rooms")
public class RoomEntity {

    @Id
    private String id;

    private String number;

    private int floor;

    private String hotelName;

    private RoomFacilities facilities;
}
