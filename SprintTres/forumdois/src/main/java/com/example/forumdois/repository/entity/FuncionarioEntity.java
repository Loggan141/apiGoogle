package com.example.forumdois.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("Funcionario")
public class FuncionarioEntity {

    @Id
    private String codigo;
    @NonNull
    private String nome;
    @NonNull
    private Integer idade;
    @NonNull
    private Double salario;

}
