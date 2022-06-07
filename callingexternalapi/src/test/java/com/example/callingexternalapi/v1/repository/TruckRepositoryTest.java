package com.example.callingexternalapi.v1.repository;

import com.example.callingexternalapi.v1.controller.util.TruckCreatorMapper;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@TestPropertySource(locations = "classpath:resources/test.properties")
@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class TruckRepositoryTest {

    private MockMvc mockMvc;
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private TruckCreatorMapper truckCreatorMapper;

    @BeforeEach
    void setUp(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(truckRepository).build();
    }

    @Test
    @DisplayName("Persist ")
    void save_PersistTruck_whenSuccessfull() throws Exception {

        TruckEntity truckToBeSaved = TruckEntity.builder()
                                                .name("Scania")
                                                .build();

//        TruckEntity truckSaved = this.truckRepository.save(truckToBeSaved);
        String json = objectMapper.writeValueAsString(truckToBeSaved);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/truck")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(MockMvcResultMatchers.status().isCreated());


//        Assertions.assertThat(truckSaved).isNotNull();
//        Assertions.assertThat(truckSaved.getId()).isNotNull();
//        Assertions.assertThat(truckSaved.getName()).isEqualTo(truckToBeSaved.getName());

    }
}