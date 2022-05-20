package com.example.callingexternalapi.model.truck;

import com.example.callingexternalapi.model.routes.RoutesResponse;
import com.example.callingexternalapi.repository.entity.RoutesEntity;
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
