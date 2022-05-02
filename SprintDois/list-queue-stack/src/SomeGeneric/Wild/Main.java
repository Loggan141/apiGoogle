package SomeGeneric.Wild;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static void printConsulta(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    //Aqui é um wildcard, o tipo curinga.
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        List<Integer> listInt = Arrays.asList(1, 2, 5, 8, 9);
        List<String> listString = Arrays.asList("I", "am", "a String");

        printList(listInt);
        printList(listString);

        List<Dog> dog = List.of(new Dog("Manu"),new Dog("Fofuxo"),new Dog("Whisky"));
        List<Cat> cat = List.of(new Cat("Sangue nos olhos"),new Cat("Patada Valente"),new Cat("Redbull"));

        printConsulta(dog);
        printConsulta(cat);

        List<Passaro> passaro = List.of(new Passaro("Loro"),new Passaro("Piriquito"));

        //printConsulta(passaro);
        printList(passaro);
    }
}
