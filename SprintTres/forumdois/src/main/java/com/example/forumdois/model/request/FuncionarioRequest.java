package com.example.forumdois.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioRequest {

        @NotBlank(message = "Codigo vazio")
        private String codigo;
        @NotBlank(message = "Nome vazio")
        private String nome;
        @NotNull(message = "Idade vazia")
        private Integer idade;
        @NotNull(message = "Salário vazio")
        private Double salario;


    }
