package AaLombok;

import lombok.Getter;

public class Main {
    public static void main(String[] args) {
        Person person=new Person();

        person.setName("Josias");
        System.out.println(person.getName());
        person.setCpf("025.007.190-81");


        Pessoa pessoa = Pessoa.builder()
                .nome("Joao")
                .age(25)
                .cpf("125836988")
                .build();


        System.out.println(pessoa);
    }
}
