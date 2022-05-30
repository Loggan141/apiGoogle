package com.example.callingexternalapi.v1.repository.entity;

import com.example.callingexternalapi.v1.integration.model.Distance;
import com.example.callingexternalapi.v1.integration.model.Duration;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class RoutesEntity {

    @JsonProperty("origin")
    private List<String> originAddresses;
    @JsonProperty("destino")
    private List<String> destinationAddresses;
    @JsonProperty("distancia")
    private Distance distance;
    @JsonProperty("duracao_percurso")
    private Duration duration;
    @JsonProperty("custo_frete")
    private double freightCost;

}
