package com.example.callingexternalapi.model.routes;

import com.example.callingexternalapi.integration.model.Distance;
import com.example.callingexternalapi.integration.model.Duration;
import com.google.maps.model.DistanceMatrixElementStatus;
import com.google.maps.model.DistanceMatrixRow;
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
