package com.example.callingexternalapi.v1.model.truck;

import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@JsonPropertyOrder({
        "id",
        "nome",
        "rotas"
})
public class TruckRequest {


    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    @Size(min = 3, max = 15)
    @NotNull
    @NotEmpty
    private String name;
    @JsonProperty("rota")
    private RoutesEntity routesEntity;
    @JsonCreator
    public TruckRequest(@JsonProperty("id")String id,
                        @JsonProperty("nome")String name,
                        @JsonProperty("rota") RoutesEntity routesEntity) {
        this.id = id;
        this.name = name;
        this.routesEntity = routesEntity;
    }
}