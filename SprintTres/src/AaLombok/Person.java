package AaLombok;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//Estando os @ aqui em cima, cria-se para todos os atributos da classe.
@Data
public class Person {

    private String name;
    @Setter (AccessLevel.PROTECTED) private String cpf;
    private int age;


}
