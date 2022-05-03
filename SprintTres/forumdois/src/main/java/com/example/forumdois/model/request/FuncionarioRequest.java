package com.example.forumdois.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class FuncionarioRequest {

        @NotBlank(message = "Nome vazio")
        private String nome;
        @NotBlank(message = "Código vazio")
        private String codigo;
        @NotNull(message = "Idade vazia")
        private Integer idade;
        @NotNull(message = "Salário vazio")
        private Double salario;


    }
