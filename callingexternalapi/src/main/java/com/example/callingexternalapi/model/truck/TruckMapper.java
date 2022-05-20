package com.example.callingexternalapi.model.truck;

import com.example.callingexternalapi.repository.entity.TruckEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class TruckMapper {

    public static TruckResponse truckRequestToResponse(TruckRequest truckRequest){
        return TruckResponse.builder()
                .id(truckRequest.getId())
                .name(truckRequest.getName())
                .routesEntity(truckRequest.getRoutesEntity())
                .build();
        }

    public static TruckEntity truckResponseToEntity(TruckResponse truckResponse){
        return TruckEntity.builder()
                .id(truckResponse.getId())
                .name(truckResponse.getName())
                .routesEntity(truckResponse.getRoutesEntity())
                .build();
    }

    public static TruckResponse truckEntityToResponse(TruckEntity truckEntity){
        return TruckResponse.builder()
                .id(truckEntity.getId())
                .name(truckEntity.getName())
                .routesEntity(truckEntity.getRoutesEntity())
                .build();
    }

    public static TruckEntity truckRequestoToEntity(TruckRequest truckRequest){
        return TruckEntity.builder()
                .id(truckRequest.getId())
                .name(truckRequest.getName())
                .routesEntity(truckRequest.getRoutesEntity())
                .build();
    }



}
