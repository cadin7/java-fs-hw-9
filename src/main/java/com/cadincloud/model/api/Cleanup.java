package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class Cleanup {

    private String id;

    private LocalDate date;

    private String roomId;
}
