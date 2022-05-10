package com.example.forumdois.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioResponse {

    private String codigo;
    private String nome;
    private Integer idade;
    private Double salario;
    private String cpf;

}
