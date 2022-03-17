import java.util.*;

public class MainColletionMillion {
    public static void main(String[] args) {
    /* - Busca de um elemento
        - Inserção de um elemento no meio da coleção
        - Inserção no inicio e no final da coleção
        - Remoção de todos elementos  da coleção
        - Remoção de um elemento no meio da coleção*/
    /* Tempo para contabilizar
        long inicio = System.currentTimeMillis();
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo + "ms"); */

    List<Integer> list=new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    Stack<Integer> Stack = new Stack<>();
    Set<String> setHash = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    HashMap<Integer, Integer> hashMap=new HashMap<>();

    int limite=1000000;

    //Perfomance List
        long inicio = System.currentTimeMillis();
        for (int i=0;i<limite;i++){
            list.add(i);
        }
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo para Map: "+tempo+"ms");

        list.contains(350400);
        list.contains(350400);

        inicio=0;
        fim=0;
        tempo=0;

    //Perfomance Map
        inicio = System.currentTimeMillis();
        for (int i=0;i<limite;i++){
            map.put(i,i+1);
        }
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo para Map: "+tempo+"ms");

    }

}
