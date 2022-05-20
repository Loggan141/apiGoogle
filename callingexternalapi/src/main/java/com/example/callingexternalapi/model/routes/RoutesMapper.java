package com.example.callingexternalapi.model.routes;

import com.example.callingexternalapi.integration.model.response.RoutesIntegrationResponse;
import com.example.callingexternalapi.repository.entity.RoutesEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class RoutesMapper {

//    public static RoutesResponse routesIntegrationResponseToRoutesResponse(RoutesIntegrationResponse routesIntegrationResponse){
//        return RoutesResponse.builder()
//                .destination_addresses(routesIntegrationResponse.getDestination_addresses())
//                .origin_addresses(routesIntegrationResponse.getOrigin_addresses())
//                .distanceMatrixRows(routesIntegrationResponse.getDistanceMatrixRows())
//                .build();
//    }
//
//    public static RoutesResponse routesRequestToRoutesResponse(RoutesRequest routesRequest){
//        return RoutesResponse.builder()
//                .destination_addresses(routesRequest.getDestination_addresses())
//                .origin_addresses(routesRequest.getOrigin_addresses())
//                .build();
//    }
//
//    public static RoutesEntity routesResponsetoEntity(RoutesResponse routesIntegrationResponse){
//        return RoutesEntity.builder()
//                .destination_addresses(routesIntegrationResponse.getDestination_addresses())
//                .origin_addresses(routesIntegrationResponse.getOrigin_addresses())
//                .distanceMatrixRows(routesIntegrationResponse.getDistanceMatrixRows())
//                .status(routesIntegrationResponse.getStatus())
//                .build();
//    }
//    public static RoutesResponse routesEntityToResponse(RoutesEntity routesEntity){
//        return RoutesResponse.builder()
//                .destination_addresses(routesEntity.getDestination_addresses())
//                .origin_addresses(routesEntity.getOrigin_addresses())
//                .distanceMatrixRows(routesEntity.getDistanceMatrixRows())
//                .build();
//    }

}
