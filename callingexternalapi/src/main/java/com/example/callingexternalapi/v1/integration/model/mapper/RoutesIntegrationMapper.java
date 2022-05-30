package com.example.callingexternalapi.v1.integration.model.mapper;

import com.example.callingexternalapi.v1.integration.RoutesIntegration;
import com.example.callingexternalapi.v1.integration.model.Distance;
import com.example.callingexternalapi.v1.integration.model.Duration;
import com.example.callingexternalapi.v1.integration.model.Element;
import com.example.callingexternalapi.v1.integration.model.request.RoutesIntegrationRequest;
import com.example.callingexternalapi.v1.integration.model.response.RoutesIntegrationResponse;
import com.example.callingexternalapi.v1.model.routes.RoutesRequest;
import com.example.callingexternalapi.v1.model.routes.RoutesResponse;
import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoutesIntegrationMapper {

    public static RoutesEntity routeIntegrationResponseToRouteEntity(RoutesIntegrationResponse routesIntegrationResponse){

        var distanceOptional = routesIntegrationResponse.getRows().stream()
                .flatMap(valueRowsIn->valueRowsIn.getElements().stream()
                .map(Element::getDistance))
                .findFirst();
        Distance distance = distanceOptional.orElseThrow(()->new RuntimeException("Distance is empty!"));

        var durationOptional = routesIntegrationResponse.getRows().stream()
                .flatMap(valueRowsIn->valueRowsIn.getElements().stream()
                .map(Element::getDuration))
                .findFirst();
        Duration duration = durationOptional.orElseThrow(()->new RuntimeException("Duration is empty!"));

        return RoutesEntity.builder()
             .destinationAddresses(routesIntegrationResponse.getDestinationAddresses())
             .originAddresses(routesIntegrationResponse.getOriginAddresses())
             .duration(duration)
             .distance(distance)
             .build();
    }

    public static RoutesIntegrationRequest routesRoutesRequestToIntegrationRequest(RoutesRequest routesRequest){
        return RoutesIntegrationRequest.builder()
                .originAddresses(routesRequest.getOriginAddresses())
                .destinationAddresses(routesRequest.getDestinationAddresses())
                .build();
    }

}
