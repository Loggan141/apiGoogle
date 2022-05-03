package AaLombok;

import lombok.*;
import lombok.experimental.SuperBuilder;

//Estando os @ aqui em cima, cria-se para todos os atributos da classe.
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Persona {

    @Setter(AccessLevel.PRIVATE) private String cpf;
    private String name;
    private int age;




}

