package com.example.callingexternalapi.v1.model.routes;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class RoutesRequest {

    private String[] origin_addresses;
    private String[] destination_addresses;

}
