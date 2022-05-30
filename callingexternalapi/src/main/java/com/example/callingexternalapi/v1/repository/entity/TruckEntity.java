package com.example.callingexternalapi.v1.repository.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.validation.constraints.Size;
@EnableMongoRepositories
@Document("Trucks")
@Data
@Builder
public class TruckEntity {
    @Id
    private String id;
    @NonNull
    @Size(min = 3, max = 15)
    private String name;
    private RoutesEntity routesEntity;

}
