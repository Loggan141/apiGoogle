package AaLombok;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Persona personas=new Persona();

        personas.setName("Josias");
        //personas.setCpf("025.000");
        System.out.println(personas.getName());


        Persona pessoa = Persona.builder()
                    .name("Joao")
                    .age(25)
                    .cpf("125836988")
                    .build();
        System.out.println(pessoa);


        Employees empregado = Employees.builder()
                .name("Josue")
                .age(58)
                .salary(BigDecimal.valueOf(258806))
                .build();

        System.out.println(empregado);


    }
}
