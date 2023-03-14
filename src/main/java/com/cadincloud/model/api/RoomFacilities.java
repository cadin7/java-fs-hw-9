package com.cadincloud.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RoomFacilities {
    private boolean tv;

    private boolean doubleBed;
}
