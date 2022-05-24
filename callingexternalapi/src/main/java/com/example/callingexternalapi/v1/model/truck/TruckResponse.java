package com.example.callingexternalapi.v1.model.truck;

import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class TruckResponse {

    private String id;
    @JsonProperty("caminhao")
    private String name;
    @JsonProperty("rota")
    private RoutesEntity routesEntity;

}
