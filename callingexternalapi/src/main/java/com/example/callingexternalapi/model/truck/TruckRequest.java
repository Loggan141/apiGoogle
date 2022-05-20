package com.example.callingexternalapi.model.truck;

import com.example.callingexternalapi.repository.entity.RoutesEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TruckRequest {

    private String id;
    private String name;
    private RoutesEntity routesEntity;


}
