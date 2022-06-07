package com.example.callingexternalapi.v1.repository.entity;

import com.example.callingexternalapi.v1.integration.model.Distance;
import com.example.callingexternalapi.v1.integration.model.Duration;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@JsonPropertyOrder({
        "origin",
        "destino",
        "distancia",
        "duracao_percurso",
        "custo_frete"
})
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
    @JsonCreator
    public RoutesEntity(@JsonProperty("origin") List<String> originAddresses,
                        @JsonProperty("destino")List<String> destinationAddresses,
                        @JsonProperty("distancia")Distance distance,
                        @JsonProperty("duracao_percurso")Duration duration,
                        @JsonProperty("custo_frete") double freightCost) {
        this.originAddresses = originAddresses;
        this.destinationAddresses = destinationAddresses;
        this.distance = distance;
        this.duration = duration;
        this.freightCost = freightCost;
    }
}
