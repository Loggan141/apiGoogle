package SomeGeneric.Wild;

import java.util.Arrays;
import java.util.List;

public class Main {


    //Aqui é um wildcard, o tipo curinga.
    public static void printList(List<?> list){
        for(Object obj:list){
            System.out.println(obj);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> listInt= Arrays.asList(1,2,5,8,9);
        List<String> listString= Arrays.asList("I","am","a String");

        printList(listInt);
        printList(listString);
    }
}
