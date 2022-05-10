package com.example.forumdois.v2.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioRequest {

        private String codigo;
        @NotNull @Size(min = 3, max = 15)
        private String nome;
        @NotNull @Min(0) @Max(99)
        private Integer idade;
        @Positive(message = "Salário não pode ser negativo!")
        private Double salario;

        private String cpf;
        private LocalDateTime datacriacao;

    }
