package com.cadincloud.model.api;

public record RoomFilters(String number,
                          Integer floor,
                          String hotelName,
                          Boolean tv,
                          Boolean doubleBed) {
}
