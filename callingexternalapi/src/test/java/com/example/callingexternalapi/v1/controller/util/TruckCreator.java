package com.example.callingexternalapi.v1.controller.util;

import com.example.callingexternalapi.v1.repository.entity.TruckEntity;

public class TruckCreator {

    private TruckEntity createTruckToBeSaved(){
        return TruckEntity.builder()
                .name("Scania")
                .build();
        }

    private TruckEntity createValidTruck(){
            return TruckEntity.builder()
                    .name("Scania")
                    .id("12321F")
                    .build();
        }
     private TruckEntity createValidUpdateTruck(){
            return TruckEntity.builder()
                    .name("Scania")
                    .id("12321F")
                    .build();
        }

}
