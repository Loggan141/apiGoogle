package com.example.callingexternalapi.repository;

import com.example.callingexternalapi.repository.entity.TruckEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TruckRepository extends MongoRepository<TruckEntity, String> {

    List<TruckEntity> findAllByIdIn(List<String> ids);
}
