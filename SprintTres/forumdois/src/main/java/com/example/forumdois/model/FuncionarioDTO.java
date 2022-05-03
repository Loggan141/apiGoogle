package com.example.forumdois.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document //é o entity so que para mongodb
//identifica um objeto para persistir no banco de dados mongodb
public class FuncionarioDTO {

    @Id
    private String codigo;
    @NonNull
    private String nome;
    @NonNull
    private Integer idade;
    @NonNull
    private Double salario;

}
