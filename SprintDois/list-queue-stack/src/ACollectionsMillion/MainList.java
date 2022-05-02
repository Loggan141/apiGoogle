package ACollectionsMillion;

import java.util.ArrayList;
import java.util.List;

public class MainList {
    public static void main(String[] args) {

        //Lista é uma estrutura de dados linear vai do indice 0 ao infinito.
        //sempre realocando os espaços a cada retirada de elemento

        List<String> cars = new ArrayList<>();

        cars.add("Corolla First (0)");
        cars.add("HB20 (1)");
        cars.add("Chevette (2)");
        cars.add("Hilux (3)");
        cars.add("Corolla Last (4)");
        cars.add("Hilux (5)");

         for(String car : cars){
            System.out.println(car);
        }

        System.out.println();
        cars.add(1,"opala (1)");

        cars.add(2,"MAREA (2)");
        for(String car : cars){
            System.out.println(car);
        }
        System.out.println();

    }
}
