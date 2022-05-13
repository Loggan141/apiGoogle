package ACollectionsMillion;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
    public static void main(String[] args) {

        //Set:conjunto. Não tem ordem de inserção de elementos, e não aceitam elementos duplicados
        //Uma das vantagens são as buscas como por objetos através do contains
        //ou remove que são mais rapidos que uma lista

        Set<String> carsHash = new HashSet<>(1,0.5f);
        Set<String> carsTree = new TreeSet<>();
        Set<String> carsLinkedHash = new LinkedHashSet<>();

        //Hash não mantem ordem de inserção

        System.out.println("============HASHSET===============");

        carsHash.add("Corolla First");
        carsHash.add("HB20");
        carsHash.add("Chevette");
        carsHash.add("Hilux");
        carsHash.add("Corolla Last");
        carsHash.add("Hilux");

        for(String car : carsHash){
            System.out.println(car);
        }

        //TreeSet é + lento, porém, a vantagem é que ele ordena automaticamente
//facload
        System.out.println("============TREESET===============");

        carsTree.add("Corolla First");
        carsTree.add("HB20");
        carsTree.add("Chevette");
        carsTree.add("Hilux");
        carsTree.add("Corolla Last");
        carsTree.add("Hilux");

        for(String car : carsTree){
            System.out.println(car);
        }

        //Nos dá a perfomance de um HashSet mas com acesso previsível e ordenado

        System.out.println("============LINKEDHASHSET===============");

        carsLinkedHash.add("Corolla First");
        carsLinkedHash.add("HB20");
        carsLinkedHash.add("Chevette");
        carsLinkedHash.add("Hilux");
        carsLinkedHash.add("Corolla Last");
        carsLinkedHash.add("Hilux");

        for(String car : carsLinkedHash){
            System.out.println(car);
        }

        System.out.println();
    }

}
