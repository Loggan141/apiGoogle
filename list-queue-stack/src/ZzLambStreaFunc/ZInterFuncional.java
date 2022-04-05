package ZzLambStreaFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ZInterFuncional {
    public static void main(String[] args) {


        //Expressões lambdas são funções anônimas
        //São utilizadas através das funções funcionais(Que possuem 1 method abstrato)
        //As principais Funções funcionais são:

        // Predicate<T> recebe um objeto do tipo T - implementa o método
        //              boolean teste(T t) - e retorna um boolean
        // Consumer<T>  Recebe mas não retorna nada - void accept(T t)
        //Function<T,R> Recebe um T e retorna um R -- R apply(T t)
        //As streams são fluxos de dados

    List<Product> list1 = new ArrayList<>();

        list1.add(new Product("TV", 1100));
        list1.add(new Product("JBL", 890));
        list1.add(new Product("Celular", 1900.50));
    List<Product> list2 = new ArrayList<>();

        list2.add(new Product("TV", 1100));
        list2.add(new Product("JBL", 890));
        list2.add(new Product("Celular", 1900.50));
    List<Product> list3 = new ArrayList<>();

        list3.add(new Product("TV", 1100));
        list3.add(new Product("JBL", 890));
        list3.add(new Product("Celular", 1900.50));

    Predicate<Product> pred = p -> p.getPrice() >= 1000;

        list1.removeIf(pred);
        for(Product prod : list1){
        System.out.println(prod);
        }
        System.out.println();
   Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1);

        list2.forEach(cons);
        for (Product prod : list2) {
            System.out.println(prod);
        }
        System.out.println();


   Function<Product, String> func= p -> p.getNome().toUpperCase();

      List<String> names = list3.stream().map(func).collect(Collectors.toList());
        for (String prod : names) {
            System.out.println(prod);
        }




    }
}
