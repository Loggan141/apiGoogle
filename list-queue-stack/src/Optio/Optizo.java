package Optio;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Optizo {
    public static void main(String[] args) {
        //optional.isPresente() -> Retorna true ou false, para se um valor existe
        //optional.empty retornara um optional vazio para a variável
        //Optional.of(coloca um valor aqui)
        //Optional.ofNullable(aceita um nullo aqui dentro);


        Optional<String> o1= Optional.of("Ola tudo bem?");
        Optional<String> o2= Optional.ofNullable("null");
        Optional<String> o3= Optional.empty();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println("-----------------------");
        System.out.println();

        Optional<String> nameOptional = findName("joi");
        System.out.println(nameOptional);

        Optional<String> nameOptional2 = findName("Loggan");
        System.out.println(nameOptional2);
        System.out.println();

        String empty=nameOptional.orElse("Empty");
        System.out.println(empty);
        String empty2=nameOptional2.orElse("Empty");
        System.out.println(empty2);



    }


    private static Optional<String> findName(String name){
            List<String> list= List.of("Felipe","Loggan");
            int i = list.indexOf(name);
            if(i>0){
                return Optional.of(list.get(i));
            }
            return Optional.empty();
        }

}
