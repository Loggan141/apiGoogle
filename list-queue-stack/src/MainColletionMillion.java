import java.sql.SQLOutput;
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
    double inicio;
    double inserMeioColecao;
    double inserInicio;
    double inserFinal;
    double remocaoTodosElem;
    double remocaoMeioColecao;
    double fim;

    //Perfomance List
        System.out.println("---Perfomance da LIST---");
        inicio = System.currentTimeMillis();

        for (int i=0;i<limite;i++){
            list.add(i);
        }
        double inicioAposInsercaoMilhao=System.currentTimeMillis();

        //Inserção de um elemento no meio da coleção
            list.add((list.size()/2),500);
            inserMeioColecao = System.currentTimeMillis()-inicioAposInsercaoMilhao;
            System.out.printf("Tempo de inserção no MEIO da collection: %.2f ms",inserMeioColecao);

        //Inserção no inicio e no final da coleção
             list.add(0,25);
             inserInicio=System.currentTimeMillis()-inicio-inserMeioColecao;
             System.out.printf("\nTempo de inserção no INICIO da collection: %.2f ms",inserInicio);


        fim = System.currentTimeMillis();
        double tempo = fim - inicio;

        System.out.println("\nTempo para List do inicio ao fim: "+tempo+"ms");
        inicio=0; fim=0; tempo=0;


    //Perfomance Map
        System.out.println();
        inicio = System.currentTimeMillis();
        for (int i=0;i<limite;i++){
            map.put(i,i+1);
        }
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo para o Map do inicio ao fim: "+tempo+"ms");

    }

}
