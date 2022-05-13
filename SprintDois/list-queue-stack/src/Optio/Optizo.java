package Optio;
import java.util.List;
import java.util.Optional;


public class Optizo {
    public static void main(String[] args) {
        //optional.isPresent() -> Retorna true ou false, para se um valor existe
        //optional.empty retornara um optional vazio para a variável
        //Optional.of(coloca um valor aqui) desde que não seja nulo e guarda um dado
        //Optional.ofNullable(aceita um nullo aqui dentro) e guarda um dado
        //orElse retorna um valor quando o optional nao tiver um valor dentro
        //orElseGet invoca um supplier quando o optional não tiver um valor
        //orElseThrow  Throw uma exception quando o optional não tiver um valor dentro

        Optional<String> o1= Optional.of("Ola tudo bem?");
        Optional<String> o2= Optional.ofNullable(null);
        Optional<String> o3= Optional.empty();
        System.out.println();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println("-----------------------");
        System.out.println();



        Optional<String> nameOptional = findName("joi");
        System.out.println(nameOptional);

        String empty=nameOptional.orElse("Empty");
        System.out.println(empty);
        System.out.println();


        Optional<String> nameOptional2 = findName("Loggan");
        System.out.println(nameOptional2);
        System.out.println();

        String empty2=nameOptional2.orElse("Empty");
        System.out.println(empty2+"\n");

        String book = "Java 8";
        Optional<String> bookOptional = Optional.ofNullable(book);
        System.out.println(bookOptional.get());

        String book2 = null;
        Optional<String> bookOptional2 = Optional.ofNullable(book2);
        System.out.println(bookOptional2.orElse("Oracle"));

        String book3 = null;
        Optional<String> bookOptional3 = Optional.ofNullable(book3);
        System.out.println(bookOptional3.orElseGet(()-> "Esta nulo"));
       //bookOptional3.map(a-> System.out.println(a.toString())).orElse(()->"Nada aqui");

        String nomeException = findName("Felipe").orElseThrow(()-> new NotFoundException("Nada foi encontrado"));
        System.out.println(nomeException);

        String nomeException2 = findName("Jose").orElseThrow(()-> new NotFoundException("Nada foi encontrado"));
        System.out.println(nomeException2);


    }

    private static Optional<String> findName(String name){
            List<String> list= List.of("Felipe","Loggan");
            int i = list.indexOf(name);
            if(i>=0){
                return Optional.ofNullable(list.get(i));
            }
            return Optional.empty();
        }


}

