package com.example.callingexternalapi.v1.controller.util;

import com.example.callingexternalapi.v1.model.truck.TruckRequest;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import lombok.Data;

@Data
public class TruckCreatorMapper {
    TruckCreator truckCreator=new TruckCreator();
    public TruckRequest creatorTruckEntityToRequest(){
        return TruckRequest.builder()
                .id(truckCreator.createValidTruck().getId())
                .name(truckCreator.createValidTruck().getName())
                .build();
    }

    public TruckResponse creatorTruckEntityToResponse(){
        return TruckResponse.builder()
                .id(truckCreator.createValidTruck().getId())
                .name(truckCreator.createValidTruck().getName())
                .build();
    }

    public TruckResponse creatorTruckEntityToResponse(TruckEntity entity){
        return TruckResponse.builder()
                .id(truckCreator.createValidTruck().getId())
                .name(truckCreator.createValidTruck().getName())
                .build();
    }

    public TruckResponse creatorTruckSavedToResponse(){
        return TruckResponse.builder()
                .name(truckCreator.createTruckToBeSaved().getName())
                .build();

    }
    public TruckRequest creatorTruckSavedToRequest(){
        return TruckRequest.builder()
                .name(truckCreator.createTruckToBeSaved().getName())
                .build();

    }

}
