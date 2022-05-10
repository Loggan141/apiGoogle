package com.example.forumdois.model.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioRequest {

        private String codigo;
        @NotBlank @NotNull @Min(3) @Max(10)
        private String nome;
        @Min(1) @Max(2)
        private Integer idade;
        @Positive(message = "Salário não pode ser negativo!")
        private Double salario;
        @CPF
        private String cpf;


    }
