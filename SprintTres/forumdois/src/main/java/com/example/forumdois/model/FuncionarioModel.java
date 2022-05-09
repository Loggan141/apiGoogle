package com.example.forumdois.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class FuncionarioModel {

    @Id
    private String codigo;
    @NonNull
    private String nome;
    @NonNull
    private Integer idade;
    @NonNull
    private Double salario;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime diaDeCriacao;

}
