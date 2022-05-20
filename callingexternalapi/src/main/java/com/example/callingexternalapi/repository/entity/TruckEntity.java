package com.example.callingexternalapi.repository.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Trucks")

@Data
@Builder
public class TruckEntity {

    @Id
    private String id;
    private String name;
    private RoutesEntity routesEntity;

}
