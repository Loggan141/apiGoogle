package com.example.callingexternalapi.v1.service;

import com.example.callingexternalapi.v1.controller.util.TruckCreator;
import com.example.callingexternalapi.v1.controller.util.TruckCreatorMapper;
import com.example.callingexternalapi.v1.exception.TruckNotFoundException;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.repository.TruckRepository;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)//através do springextension diz que vou usr o Junity com o Spring
class TruckServiceTest {
    @InjectMocks //Quando quer testar a classe em si, por exemplo,  a truckService
    private TruckService truckService;

    @Mock //Mock do comportamento, vamos definir o comportamento do truckService
    private TruckRepository truckRepositoryMock;

    @BeforeEach
        //antes de cada
    void setUp() {
        TruckCreator truckCreator = new TruckCreator();

        List<TruckEntity> truckEntities = List.of(truckCreator.createValidTruck());

        BDDMockito.when(truckRepositoryMock.findAllByIdIn(ArgumentMatchers.any()))
                                           .thenReturn(truckEntities);

        BDDMockito.when(truckRepositoryMock.save(ArgumentMatchers.any(TruckEntity.class)))
                .thenReturn(truckCreator.createValidTruck());

        BDDMockito.when(truckRepositoryMock.save(ArgumentMatchers.any(TruckEntity.class)))
                .thenReturn(truckCreator.createValidUpdateTruck());


        //Quando retornar void:
        //Delete Truck
        BDDMockito.doNothing().when(truckRepositoryMock).delete(ArgumentMatchers.any(TruckEntity.class));
        //Delete Truck's Route
        BDDMockito.doNothing().when(truckRepositoryMock).delete(ArgumentMatchers.any(TruckEntity.class));


    }

    @Test
    @DisplayName("FindAll or By Id - Returns list of Trucks when successful")
    void truckFindAllById_ReturnsListOfTrucks_WhenSuccessful() {
        TruckCreator truckCreator = new TruckCreator();
        String expectedID = truckCreator.createValidTruck().getId();

        List<String> idTest = List.of("12321F");

        List<TruckResponse> truckResponses = truckService.getTrucksByIdOrAll(idTest);

        Assertions.assertThat(truckResponses)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(truckResponses.get(0).getId())
                                                   .isEqualTo(expectedID);
    }

    @Test
    @DisplayName("FindAllOrByIdNotFound - Throws not found exception")
    void truckFindAllById_ReturnsEmptyListOfTrucks_WhenTruckIsNotFound() {
        BDDMockito.when(truckRepositoryMock.findAllById(ArgumentMatchers.any()))
                .thenReturn(Collections.emptyList());

        List<String> id = List.of("312321");

        List<TruckResponse> truckResponses = truckService.getTrucksByIdOrAll(id);

        Assertions.assertThat(truckResponses).isNotNull()
                                             .isNotEmpty();
    }

    @Test
    @DisplayName("Save a Truck - Returns Truck when successful")
    void SaveTheTruck_ReturnsTruck_WhenTruckIsSuccessful() {

        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();

        TruckResponse truckResponses = truckService.createTruck(truckCreatorMapper.creatorTruckEntityToRequest());

        Assertions.assertThat(truckResponses).isNotNull()
                                             .isEqualTo(truckCreatorMapper.creatorTruckEntityToResponse());
    }

//    @Test
//    @DisplayName("Save a Truck - Returns Truck when successful")
//    void SaveTheTruck_DontReturns_TruckAlreadyExists() {
//        TruckCreator truckCreator = new TruckCreator();
//        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();
//
//        TruckResponse truckResponses = truckService.createTruck(truckCreatorMapper.creatorTruckEntityToRequest());
//
//        Assertions.assertThat(truckResponses).isNotNull()
//                                             .isEqualTo(truckCreator.createValidTruck());
//    }

    @Test
    @DisplayName("Update a Truck - Returns the updated Truck when successful")
    void updateTheTruck_ReturnsUpdatedTruck_WhenTruckIsSuccessful() {
         TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();

         var truckRequest = truckCreatorMapper.creatorTruckEntityToRequest();
        Assertions.assertThatExceptionOfType(TruckNotFoundException.class)
                        .isThrownBy(()->truckService
                                .updateDataByIdOrThrowsTruckNotFoundException(truckRequest));
    }

    @Test
    @DisplayName("Delete a Truck when successful")
    void delete_RemovesTruck_WhenTruckIsSuccessful() {
        List<String> anyId = List.of("1");

        Assertions.assertThatCode(() -> truckService.deleteTruckByIdOrAll(anyId)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Delete a Truck's Route or throws a RuntimeException when not successful")
    void deleteRoute_RemovesTruckRoute_WhenSuccessful() {

        Assertions.assertThatExceptionOfType(TruckNotFoundException.class)
                .isThrownBy(()->truckService
                        .deleteRouteTruckByIdOrThrowsTruckNotFoundException("1"));

    }

//    @Test
//    @DisplayName("FreightCost return freightcost when successful")
//    void freightCost_CalculateFreight_ReturnsCost_WhenSuccessful() {
//        String distanceToTest="250 km";
//        double expectedValue=295;
//        double valueReal = truckService.freightCost(distanceToTest);
//
//        Assertions.assertThat(valueReal).isEqualTo(expectedValue);
//
//    }


}