package com.example.callingexternalapi.v1.handler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GlobalExceptionHandlerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void handleMethodNotSupported() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/truck"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void handleMissingServletRequestParameterException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/truck"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void handleHttpMessageNotReadableException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/truck")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ nome\" = \"Mitsubish\"}"))

                .andExpect(status().is4xxClientError());
    }

    @Test
    void handleNullPointerException() {
    }

    @Test
    void handleMethodArgumentNotValidException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/truck")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ nome\" = null}"))
                .andExpect(status().isBadRequest());

    }

    @Test
    void handleUnexpectedTypeException() {
    }

    @Test
    void handleIllegalArgumentException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/v1/truck?id=")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": null, \"nome\":\"Mitsubishi\"}")).andExpect(status().isNotAcceptable());
    }

    @Test
    void handleHttpMessageConversionException() {
    }
}