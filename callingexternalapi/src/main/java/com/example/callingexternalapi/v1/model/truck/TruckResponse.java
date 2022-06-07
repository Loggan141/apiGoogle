package com.example.callingexternalapi.v1.model.truck;

import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

@JsonPropertyOrder({
        "id",
        "nome",
        "rota"
})
public class TruckResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("rota")
    private RoutesEntity routesEntity;
    @JsonCreator
    public TruckResponse(@JsonProperty("id")String id, @JsonProperty("nome")String name,  @JsonProperty("rota") RoutesEntity routesEntity) {
        this.id = id;
        this.name = name;
        this.routesEntity = routesEntity;
    }
}
