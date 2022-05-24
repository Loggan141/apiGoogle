package com.example.callingexternalapi.v1.model.routes;

import com.example.callingexternalapi.v1.integration.model.Distance;
import com.example.callingexternalapi.v1.integration.model.Duration;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RoutesResponse {

    private List<String> origin_addresses;
    private List<String> destination_addresses;
    private Distance distance;
    private Duration duration;

}
