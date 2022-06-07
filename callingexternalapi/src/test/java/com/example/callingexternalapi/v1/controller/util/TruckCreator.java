package com.example.callingexternalapi.v1.controller.util;

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
                    .id("12321F")
                    .name("Scania")
                    .routesEntity(null)
                    .build();
        }
     public TruckEntity createValidUpdateTruck(){
            return TruckEntity.builder()
                    .name("Scania")
                    .id("12321F")
                    .build();
        }

}
