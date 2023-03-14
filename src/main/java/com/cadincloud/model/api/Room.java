package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Room {
    private String id;

    private String number;

    private int floor;

    private String hotelName;

    private RoomFacilities facilities;
}
