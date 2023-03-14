package com.cadincloud.repository;

import com.cadincloud.model.entity.CleaningProcedureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProcedureRepository extends MongoRepository<CleaningProcedureEntity, String> {
}
