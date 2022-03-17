import java.util.ArrayList;
import java.util.List;

public class MainList {
    public static void main(String[] args) {

        //Lista é uma estrutura de dados linear vai do indice 0 ao infinito.
        //sempre realocando os espaços a cada retirada de elemento

        List<String> cars = new ArrayList<>();

        cars.add("Corolla First");
        cars.add("HB20");
        cars.add("Chevette");
        cars.add("Hilux");
        cars.add("Corolla Last");
        cars.add("Hilux");

        cars.add(1,"opala");

        for(String car : cars){
            System.out.println(car);
        }
    //Inicio da coleção de 1milhão

    long inicio = System.currentTimeMillis();

    }
}
