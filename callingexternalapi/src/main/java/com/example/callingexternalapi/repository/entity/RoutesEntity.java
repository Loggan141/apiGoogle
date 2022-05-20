package com.example.callingexternalapi.repository.entity;

import com.example.callingexternalapi.integration.model.Distance;
import com.example.callingexternalapi.integration.model.Duration;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class RoutesEntity {

    @JsonProperty("origin")
    private List<String> origin_addresses;
    @JsonProperty("destino")
    private List<String> destination_addresses;
    @JsonProperty("distancia")
    private Distance distance;
    @JsonProperty("duracao_percurso")
    private Duration duration;


}
