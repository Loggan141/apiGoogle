package ASimpleColletions;

import java.util.LinkedList;
import java.util.Queue;

public class MainQueue {
    public static void main(String[] args) {
        //First IN, First OUT
        //Deve ser implementada com uma list encadeada- LinkedList
        //Queue é uma interface da interface colletion

        Queue<String> car = new LinkedList<>();
        car.add("Corolla First");
        car.add("HB20");
        car.add("Chevette");
        car.add("Hilux");
        car.add("Corolla Last");
        car.add("Hilux");


        for(String cars : car){
            System.out.println(cars);
        }

        System.out.println("\nCarro no topo : "+car.peek()+"\n");

        System.out.println("Carro que será retirado : "+car.poll()+"\n");

        for(String cars : car){
            System.out.println(cars);
        }

    }
}
