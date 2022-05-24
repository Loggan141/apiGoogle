package com.example.callingexternalapi.v1.model.truck;

import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TruckRequest {

    private String id;
    private String name;
    private RoutesEntity routesEntity;


}
