package com.example.forumdois.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioRequest {

        private String codigo;
        @NotBlank @NotNull
        private String nome;

        private Integer idade;
        @Positive(message = "Salário não pode ser negativo!")
        private Double salario;

        private String cpf;


    }
