package AaLombok;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class Pessoa {

    String nome;
    String cpf;
    int age;
}
