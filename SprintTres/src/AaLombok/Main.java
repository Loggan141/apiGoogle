package AaLombok;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Person persona=new Person();

        persona.setName("Josias");
        persona.setCpf("025.000");
        System.out.println(persona.getName());


        Person pessoa = Person.builder()
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
