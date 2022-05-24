package com.example.callingexternalapi.v1.controller;

import com.example.callingexternalapi.v1.controller.util.TruckCreator;
import com.example.callingexternalapi.v1.service.TruckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)//através do springextension diz que vou usr o Junity com o Spring
class TruckControllerTest {
    @InjectMocks //Quando quer testar a classe em si, por exemplo,  o truckontroller
    private TruckController truckController;

    @Mock //Mock do comportamento, vamos definir o comportamento do truckService
    private TruckService truckService;

    @BeforeEach //antes de cada

    void setUp(){
        new Truck<>TruckCreator()
    }

    @Test
     void test(){

    }


}