package com.example.callingexternalapi.v1.controller;

import com.example.callingexternalapi.v1.controller.util.TruckCreator;
import com.example.callingexternalapi.v1.controller.util.TruckCreatorMapper;
import com.example.callingexternalapi.v1.model.truck.TruckRequest;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import com.example.callingexternalapi.v1.service.TruckService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
@ExtendWith(SpringExtension.class)//através do springextension diz que vou usr o Junity com o Spring
class TruckControllerTest {
    @InjectMocks //Quando quer testar a classe em si, por exemplo,  a TruckController
    private TruckController truckController;
    @Mock //Mock do comportamento, vamos definir o comportamento do truckService
    private TruckService truckServiceMock;

    @BeforeEach //antes de cada
    void setUp(){

        TruckCreator truckCreator=new TruckCreator();
        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();
        List<TruckEntity> truckEntities = List.of(truckCreator.createValidTruck());

        BDDMockito.when(truckServiceMock.getTrucksByIdOrAll(ArgumentMatchers.any()))
                 .thenReturn(truckEntities.stream()
                                          .map(truckCreatorMapper::creatorTruckEntityToResponse)
                                          .toList());

        BDDMockito.when(truckServiceMock
                        .updateDataByIdOrThrowsTruckNotFoundException(ArgumentMatchers.any(TruckRequest.class)))
                        .thenReturn(truckCreatorMapper.creatorTruckEntityToResponse());

        BDDMockito.when(truckServiceMock.createTruck(ArgumentMatchers.any(TruckRequest.class)))
                                        .thenReturn(truckCreatorMapper.creatorTruckSavedToResponse());

        //Quando retornar void:
          BDDMockito.doNothing().when(truckServiceMock).deleteTruckByIdOrAll(ArgumentMatchers.anyList());
          BDDMockito.doNothing().when(truckServiceMock).deleteRouteTruckByIdOrThrowsTruckNotFoundException(ArgumentMatchers.any());



    }
    @Test
    @DisplayName("FindAll or By Id - Returns list of Trucks when successful")
    void truckFindAllById_ReturnsListOfTrucks_WhenSuccessful(){
        TruckCreator truckCreator = new TruckCreator();
        String expectedID = truckCreator.createValidTruck().getId();

        List<String> idTest = List.of("12321F");

        List<TruckResponse> truckResponses = truckController.getTrucks(idTest)
                                                            .getBody();

        Assertions.assertThat(truckResponses)
                            .isNotNull()
                            .isNotEmpty()
                             .hasSize(1);

        Assertions.assertThat(truckResponses.get(0).getId())
                            .isEqualTo(expectedID);
    }

     @Test
     @DisplayName("FindAll or By Id - Returns list of Trucks when successful")
     void truckFindAllById_ReturnsListOfTrucks_WhenTruckIsNotFound(){
        BDDMockito.when(truckServiceMock.getTrucksByIdOrAll(ArgumentMatchers.any()))
                 .thenReturn(Collections.emptyList());

        List<String> id = List.of("312321");

        List<TruckResponse> truckResponses = truckController.getTrucks(id).getBody();

        Assertions.assertThat(truckResponses).isNotNull()
                                             .isEmpty();
     }

    @Test
    @DisplayName("Save a Truck - Returns Truck when successful")
    void SaveTheTruck_ReturnsTruck_WhenTruckIsSuccessful(){
        TruckCreator truckCreator = new TruckCreator();

        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();

        TruckResponse truckResponses = truckController.createNewTruck(truckCreatorMapper.creatorTruckSavedToRequest());

        Assertions.assertThat(truckResponses).isNotNull()
                                             .isEqualTo(truckCreator.createTruckToBeSaved());
    }

    @Test
    @DisplayName("Update a Truck - Returns the updated Truck when successful")
    void updateTheTruck_ReturnsUpdatedTruck_WhenTruckIsSuccessful(){
        TruckCreator truckCreator = new TruckCreator();
        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();

        TruckResponse truckResponse = truckController.updateTruckData(truckCreatorMapper.creatorTruckEntityToRequest());

        Assertions.assertThat(truckResponse).isNotNull()
                                            .isEqualTo(truckCreatorMapper.creatorTruckEntityToResponse());
     }

    @Test
    @DisplayName("Delete a Truck when successful")
    void delete_RemovesTruck_WhenTruckIsSuccessful(){
        List<String> anyId = List.of("1");

        Assertions.assertThatCode(()->truckController.deleteTruck(anyId)).doesNotThrowAnyException();

        ResponseEntity<Void> entity = truckController.deleteTruck(anyId);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Delete a Truck's Route when successful")
    void deleteRoute_RemovesTruckRoute_WhenRouteIsSuccessful(){
        Assertions.assertThatCode(()->truckController.deleteRouteTruckById("1")).doesNotThrowAnyException();

        ResponseEntity<Void> entity = truckController.deleteRouteTruckById("1");

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
     }












}