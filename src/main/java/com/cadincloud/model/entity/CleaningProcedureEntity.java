package com.cadincloud.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "cleaning_procedures")
public class CleaningProcedureEntity {

    @Id
    private String id;

    private String name;

    private int outcome;

    private String cleanupId;
}
