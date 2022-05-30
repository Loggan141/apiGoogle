package com.example.callingexternalapi.v1.model.routes;

import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class RoutesMapper {

    public static RoutesResponse routesEntityToResponse(RoutesEntity routesEntity){
        return RoutesResponse.builder()
                .originAddresses(routesEntity.getOriginAddresses())
                .destinationAddresses(routesEntity.getDestinationAddresses())
                .distance(routesEntity.getDistance())
                .duration(routesEntity.getDuration())
                .freightCost(routesEntity.getFreightCost())
                .build();

    }


}
