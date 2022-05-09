package com.example.forumdois.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioResponse {

    @NotBlank
    private String codigo;

    private String nome;

    private Integer idade;

    private Double salario;

}
