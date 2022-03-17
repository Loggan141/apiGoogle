import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {
        //Stack - First IN is the Last OUT

        Stack<String> cars= new Stack<>();
        cars.add("Corolla Primeiro");
        cars.add("HB20");
        cars.add("Chevette");
        cars.add("Hilux");
        cars.add("Corolla Ultimo");
        cars.add("Hilux");

        for(String car : cars){
            System.out.println(car);
        }

        System.out.println("\ncar retirado da pilha será o último que entrou : "+cars.pop()+"\n");
        System.out.println("---APÓS O POP---");
        for(String car : cars){
            System.out.println(car);
        }
    //Inicio da coleção de 1milhão

    long inicio = System.currentTimeMillis();

    }
}
