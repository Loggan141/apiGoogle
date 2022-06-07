package com.example.callingexternalapi.v1.model.routes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RoutesRequest {

    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses;
    @JsonProperty("origin_addresses")
    private List<String> originAddresses;
    @JsonCreator
    public RoutesRequest(@JsonProperty("destination_addresses")List<String> destinationAddresses,
                         @JsonProperty("origin_addresses")List<String> originAddresses) {
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
    }
}
