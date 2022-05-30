package com.example.callingexternalapi.v1.model.truck;

import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class TruckRequest {

    @NotNull
    private String id;
    private String name;
    private RoutesEntity routesEntity;

}
