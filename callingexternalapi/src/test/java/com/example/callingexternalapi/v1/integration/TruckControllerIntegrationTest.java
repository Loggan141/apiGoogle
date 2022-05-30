package com.example.callingexternalapi.v1.integration;
import com.example.callingexternalapi.v1.controller.TruckController;
import com.example.callingexternalapi.v1.controller.util.TruckCreator;
import com.example.callingexternalapi.v1.repository.TruckRepository;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import com.example.callingexternalapi.v1.service.TruckService;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
//@DataMongoTest
@AllArgsConstructor
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TruckController.class, TruckService.class, TruckRepository.class})
class TruckControllerIntegrationTest {

    private TruckRepository truckRepository;
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Find All or By Id - Returns list of Trucks when successful")
    void truckFindAllById_ReturnsListOfTrucks_WhenSuccessful() {
        TruckCreator truckCreator = new TruckCreator();
        String expectedName = truckCreator.createTruckToBeSaved().getName();
        TruckEntity savedTruckEntity = truckRepository.save(truckCreator.createTruckToBeSaved());

        List<TruckEntity> truckEntities = testRestTemplate.exchange("/v1/truck", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<TruckEntity>>() {
                }).getBody();

        Assertions.assertThat(truckEntities).isNotEmpty().isNotNull().hasSize(1);

        Assertions.assertThat(truckEntities.get(0).getName()).isEqualTo(expectedName);

    }
//
//
//
//    @Test
//    @DisplayName("FindAll or By Id - Returns list of Trucks when successful")
//    void truckFindAllById_ReturnsListOfTrucks_WhenTruckIsNotFound(){
//        BDDMockito.when(truckServiceMock.getTrucksByIdOrAll(ArgumentMatchers.any()))
//                .thenReturn(Collections.emptyList());
//
//        List<String> id = List.of("312321");
//
//        List<TruckResponse> truckResponses = truckController.getTrucks(id).getBody();
//
//        Assertions.assertThat(truckResponses).isNotNull()
//                .isEmpty();
//    }
//
//    @Test
//    @DisplayName("Save a Truck - Returns Truck when successful")
//    void SaveTheTruck_ReturnsTruck_WhenTruckIsSuccessful(){
//        TruckCreator truckCreator = new TruckCreator();
//
//        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();
//
//        TruckResponse truckResponses = truckController.createNewTruck(truckCreatorMapper.creatorTruckSavedToRequest());
//
//        Assertions.assertThat(truckResponses).isNotNull()
//                .isEqualTo(truckCreator.createTruckToBeSaved());
//    }
//
//    @Test
//    @DisplayName("Update a Truck - Returns the updated Truck when successful")
//    void updateTheTruck_ReturnsUpdatedTruck_WhenTruckIsSuccessful(){
//        TruckCreator truckCreator = new TruckCreator();
//        TruckCreatorMapper truckCreatorMapper = new TruckCreatorMapper();
//
//        TruckResponse truckResponse = truckController.updateTruckData(truckCreatorMapper.creatorTruckEntityToRequest());
//
//        Assertions.assertThat(truckResponse).isNotNull()
//                .isEqualTo(truckCreatorMapper.creatorTruckEntityToResponse());
//    }
//
//    @Test
//    @DisplayName("Delete a Truck when successful")
//    void delete_RemovesTruck_WhenTruckIsSuccessful(){
//        List<String> anyId = List.of("1");
//
//        Assertions.assertThatCode(()->truckController.deleteTruck(anyId)).doesNotThrowAnyException();
//
//        ResponseEntity<Void> entity = truckController.deleteTruck(anyId);
//
//        Assertions.assertThat(entity).isNotNull();
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//
//    @Test
//    @DisplayName("Delete a Truck's Route when successful")
//    void deleteRoute_RemovesTruckRoute_WhenRouteIsSuccessful(){
//        Assertions.assertThatCode(()->truckController.deleteRouteTruckById("1")).doesNotThrowAnyException();
//
//        ResponseEntity<Void> entity = truckController.deleteRouteTruckById("1");
//
//        Assertions.assertThat(entity).isNotNull();
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);


}