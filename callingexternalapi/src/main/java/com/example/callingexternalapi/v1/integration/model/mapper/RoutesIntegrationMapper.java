package com.example.callingexternalapi.v1.integration.model.mapper;

import com.example.callingexternalapi.v1.integration.model.response.RoutesIntegrationResponse;
import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import lombok.Builder;

@Builder
public class RoutesIntegrationMapper {


    public static RoutesEntity routeIntegrationResponseToRouteResponse(RoutesIntegrationResponse routesIntegrationResponse){
        var distance = routesIntegrationResponse.getRows().stream()
                .flatMap(valueRowsIn->valueRowsIn.getElements().stream()
                        .map(valueInElements->valueInElements.getDistance()))
                .findFirst().get();

        var duration = routesIntegrationResponse.getRows().stream()
                .flatMap(valueRowsIn->valueRowsIn.getElements().stream()
                        .map(valueInElements->valueInElements.getDuration()))
                .findFirst().get();


        return RoutesEntity.builder()
             .destination_addresses(routesIntegrationResponse.getDestinationAddresses())
             .origin_addresses(routesIntegrationResponse.getOriginAddresses())
             .duration(duration)
             .distance(distance)
             .build();
    }


}
