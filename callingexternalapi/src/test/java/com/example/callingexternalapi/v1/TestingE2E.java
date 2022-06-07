package com.example.callingexternalapi.v1;

import com.example.callingexternalapi.v1.integration.RoutesIntegration;
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
public class TestingE2E {

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
    @DisplayName("Testing something")
    void shouldNotReturnRoute() {

         mockServer.when(request()
                        .withMethod("DELETE")
                        .withPath("/v1/truck/routeDelete/12321F"))
                .respond(response()
                        .withStatusCode(204));
    }



}
