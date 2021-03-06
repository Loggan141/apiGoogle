package ZzLambStreaFunc;

import java.util.*;
import java.util.stream.Collectors;


public class LambStreaFunctiona {


    public static void main(String[] args) {
         //As streams são fluxos de dados

            List<Integer> list = Arrays.asList(4,1,2,5,3);

        //Filter recebe um predicate que retorna um boolean
        //Ou seja, se retornar um true ele fará a operação

            List<Integer> list2 = list.stream().filter(a->a%2==0)
                                  .collect(Collectors.toList());

        //o forEach é um consumer que recebe mas não retorna nada
             list2.stream().forEach(a-> System.out.println(a));

            System.out.println();
        //Function recebe um T e retorna um R(diferentes)
        //e o map executa um comando especifico em cada um dos dados

            list.stream().map(a->a*2).forEach(a-> System.out.println(a));

            System.out.println();
        //Aqui foi chamado o método comparator

        /*list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });*/ //Para se evitar este monte de código, agora possuimos a expressão lambda a qual podemos
              //chamar métodos pontuais

        list.sort((l1,l2)->l1-l2); //Aqui fica em ordem crescente, para decrescente é só trocar para (l2-l1)
        list.forEach(a-> System.out.println(a));

        Set<List<String>> setizinho = new HashSet<>();

        List<String> graphicalIssues = List.of("José", "Pinheiro", "Carcavano");
        List<String> graphicalStones = List.of("Romero", "Castanheiro", "Papavasco");
        List<String> graphicalDiseases = List.of("Santana", "Figueirano", "Franciscano");
        setizinho.add(graphicalDiseases);
        setizinho.add(graphicalIssues);
        setizinho.add(graphicalStones);

        //flatmap serve para tirar algo de dentro de algum lugar, de colleções

        setizinho.stream().flatMap(Collection::stream).forEach(System.out::println);


    //todo olhar flatmap e map diferenças
    }
}
