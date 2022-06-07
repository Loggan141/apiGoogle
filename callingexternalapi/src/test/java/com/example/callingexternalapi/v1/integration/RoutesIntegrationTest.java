package com.example.callingexternalapi.v1.integration;

import com.example.callingexternalapi.v1.integration.model.Distance;
import com.example.callingexternalapi.v1.integration.model.Duration;
import com.example.callingexternalapi.v1.model.routes.RoutesRequest;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.repository.entity.RoutesEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoutesIntegrationTest {

    @MockBean
    private RoutesIntegration routesIntegration;
    @Autowired
    private ObjectMapper objectMapper;
    private ClientAndServer mockServer;


    @BeforeEach
    public void startServer() {
        mockServer = startClientAndServer(1080);
    }

    @AfterEach
    public void stopServer() {
        mockServer.stop();
    }


    @Test
    @DisplayName("GetRoutesFromAPI")
    void getRoutes_fromApi_google() throws JsonProcessingException {
        List<String> destination = List.of("Sao Paulo - SP, Brasil");
        List<String> origin = List.of("Canoas - RS, Brasil");
        var routeRequest = RoutesRequest.builder()
                .originAddresses(origin)
                .destinationAddresses(destination)
                .build();
        var routeRequestToJson = objectMapper.writeValueAsString(routeRequest);
        var truckResponse = TruckResponse.builder()
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
        var truckResponseToJson = objectMapper.writeValueAsString(truckResponse);


      mockServer.when(request()
                       .withMethod("POST")
                       .withPath("/v1/truck/newroute/12321F")
                       .withBody(exact(routeRequestToJson)))
       .respond(response()
                       .withStatusCode(201)
                       .withBody(truckResponseToJson)
         );

    }

}