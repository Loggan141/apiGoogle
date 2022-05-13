package com.example.forumdois.v2.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime datacriacao;

}
