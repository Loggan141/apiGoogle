package com.example.forumdois.v1.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class FuncionarioEntity {

    @Id
    private String codigo;
    private String nome;
    private Integer idade;
    private Double salario;
    private String cpf;

//    @NotNull validates that the annotated property value is not null.
//    @AssertTrue validates that the annotated property value is true.
//    @Size validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties.
//    @Min validates that the annotated property has a value no smaller than the value attribute.
//    @Max validates that the annotated property has a value no larger than the value attribute.
//    @Email validates that the annotated property is a valid email address.
}
