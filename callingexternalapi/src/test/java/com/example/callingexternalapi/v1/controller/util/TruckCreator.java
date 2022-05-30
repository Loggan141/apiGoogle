package com.example.callingexternalapi.v1.controller.util;

import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import lombok.Data;

@Data

public class TruckCreator {

    public TruckEntity createTruckToBeSaved(){
        return TruckEntity.builder()
                .name("Scania")
                .build();
        }

    public TruckEntity createValidTruck(){
            return TruckEntity.builder()
                    .name("Scania")
                    .id("12321F")
                    .build();
        }
     public TruckEntity createValidUpdateTruck(){
            return TruckEntity.builder()
                    .name("Scania")
                    .id("12321F")
                    .build();
        }

}
