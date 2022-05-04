package com.example.forumdois.model;


import lombok.*;
import org.springframework.data.annotation.Id;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//é o entity so que para mongodb
//identifica um objeto para persistir no banco de dados mongodb
public class Funcionario {

    @Id
    private String codigo;
    @NonNull
    private String nome;
    @NonNull
    private Integer idade;
    @NonNull
    private Double salario;

}
