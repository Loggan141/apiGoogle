package com.example.callingexternalapi.v1.integration;

import com.example.callingexternalapi.v1.exception.TruckNotFoundException;
import com.example.callingexternalapi.v1.integration.model.Distance;
import com.example.callingexternalapi.v1.integration.model.Duration;
import com.example.callingexternalapi.v1.integration.model.request.RoutesIntegrationRequest;
import com.example.callingexternalapi.v1.model.truck.TruckRequest;
import com.example.callingexternalapi.v1.repository.TruckRepository;
import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc //Sobe todos o contexto da aplicação
@ExtendWith(SpringExtension.class)
@SpringBootTest

class TruckControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc; //testing server-side
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private RoutesIntegration routesIntegrationMock;
    @MockBean
    private TruckRepository truckRepositoryMock;


    @Test
    @DisplayName("Find By Id")
    void truckGetFindById_shouldReturns_statusCode200() throws Exception {

        var truckToGetEntity = List.of(TruckEntity.builder()
                .id("12321F")
                .name("Scania")
                .build());
        var ids = List.of("12321F");

        when(truckRepositoryMock.findAllByIdIn(ids)).thenReturn(truckToGetEntity);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/truck")
                        .param("id","12321F"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].nome").value("Scania"))
                .andReturn();

    }


//    @Test
//    @DisplayName("TruckGet - Returns TruckNotFoundException")
//    void truckGetFindAll_ReturnsTruckNotFoundException() throws Exception {
//        var truckToGet = TruckEntity.builder()
//                .id("12312G")
//                .name("SomeExpectedTruck")
//                .build();
//
//        mockMvc.perform(MockMvcRequestBuilders
//            .get("/v1/truck?id=12321F"))
//
//            .andDo(print())
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is4xxClientError());
//    }

    @Test
    @DisplayName("PostNewTruck")
    void truckPost_shouldReturns_statusCode201() throws Exception {

       var truckUpdated=TruckEntity.builder()
               .id("12321F")
               .name("Scania")
               .build();
        var truckToUpdate=TruckRequest.builder()
               .id("12321F")
               .name("Scania")
               .build();

        when(truckRepositoryMock.save(any())).thenReturn(truckUpdated);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/truck")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(objectMapper.writeValueAsString(truckToUpdate)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Scania"))
                .andExpect(status().isCreated());
    }


    @Test
    @DisplayName("Update a Truck statuscode200")
    void truckUpdate_shouldReturns_statusCode200() throws Exception {

        var truckToGet=TruckEntity.builder()
                .id("12321F")
                .name("Scania")
                .build();

        var truckUpdated=TruckEntity.builder()
                .id("12321F")
                .name("Scania2")
                .build();

        truckRepositoryMock.save(truckToGet);
        when(truckRepositoryMock.save(any())).thenReturn(truckUpdated);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/truck")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(truckUpdated))
                        .accept(MediaType.APPLICATION_JSON))
              //  .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Scania2"))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    @DisplayName("Try Update a Truck throws NotFoundException404")
    void truckUpdate_NotFoundException_shouldReturns_statusCode404() throws Exception {

        var truckToUpdateNotFound = TruckRequest.builder()
                .id("12321F")
                .build();

        when(truckRepositoryMock.findAllByIdIn(any())).thenThrow(TruckNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/v1/truck")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(truckToUpdateNotFound)))
               .andExpect(status().is4xxClientError());
    }


    @Test
    @DisplayName("Truck delete statuscode204")
    void truckDelete_shouldReturns_statusCode204() throws Exception {
           mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/truck/delete")
                        .param("id",""))
               .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Route delete Truck delete status code204")
    void shouldDeleteRouteTruck_shouldReturns_statusCode204() throws Exception {
        List<String> destination = List.of("Sao Paulo - SP, Brasil");
        List<String> origin = List.of("Canoas - RS, Brasil");

        var routesRequest = RoutesIntegrationRequest.builder()
                .originAddresses(origin)
                .destinationAddresses(destination)
                .build();


        var truckToSave = TruckEntity.builder()
                .id("12321F")
                .name("Scania")
                .routesEntity(RoutesEntity.builder()
                        .originAddresses(origin)
                        .destinationAddresses(destination)
                        .distance(Distance.builder()
                                .value(1386447)
                                .text("1,386 km")
                                .build()
                        )
                        .duration(Duration.builder()
                                .value(63387)
                                .text("17 hours 36 mins")
                                .build())
                        .freightCost(1399.86)

                        .build())
                .build();

        this.truckRepositoryMock.save(truckToSave);



           mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/truck/routeDelete/12321F"))
           .andExpect(status().isNoContent());

    }

    @Test
    @DisplayName("Try delete a truck's route Throws TruckNotFoundException")
    void shouldDeleteATruckRoute_TruckNotfoundException() throws Exception {
       var truckToSave = TruckEntity.builder()
               .id("56468F")
               .name("Scania")
               .build();

        this.truckRepositoryMock.save(truckToSave);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/truck/routeDelete/12321F"))
                .andExpect(status().is4xxClientError());
    }

}