package com.example.callingexternalapi.integration.model.response;

import com.example.callingexternalapi.integration.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.maps.model.DistanceMatrixElementStatus;
import com.google.maps.model.DistanceMatrixRow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "destination_addresses",
        "origin_addresses",
        "rows",
        "status"
})
public class RoutesIntegrationResponse {

    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses;
    @JsonProperty("origin_addresses")
    private List<String> originAddresses;
    @JsonProperty("rows")
    private List<Row> rows;
    @JsonProperty("status")
    private String status;

}
