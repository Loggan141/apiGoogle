package com.example.callingexternalapi.integration.model.mapper;

import com.example.callingexternalapi.integration.model.response.RoutesIntegrationResponse;
import com.example.callingexternalapi.repository.entity.RoutesEntity;
import com.google.maps.model.Duration;
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
