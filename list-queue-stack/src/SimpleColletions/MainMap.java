package SimpleColletions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainMap {
    public static void main(String[] args) {

        //Nenhum map aceita elemento com Key duplicado
        //Mas aceita o value duplicado
        //Map não pertence a Interface Colletion


        //Hashmap extende a classe Abstractmap para usar uma tabela de hash
        //ordem de inserção não é preservada

        System.out.println("=======HashMap=======\n");
        Map<Integer,String> map = new HashMap<>();

        map.put(0,"Ponto zero");
        map.put(2, "Loggan");
        map.put(4, "Pereira");
        map.put(5, "Oscar");
        map.put(6, "Joker2");
        map.put(1, "Felipe");
        map.put(6, "Joker1"); //Este é o ultimo a ser inserido, sobreescreve o Joker2
        map.put(3, "Leal");
        map.put(5, "Oscar2");//Este é o último a ser inserido, sobreescrevendo o Oscar1

        for(Map.Entry<Integer, String> mapping : map.entrySet()){
            System.out.println(mapping);
        }

        System.out.println();
        System.out.println();


        //Tree organiza automaticamente em ordem pelo key

        System.out.println("========TreeMap========\n");

        Map<Integer,String> mapTree = new TreeMap<>();

        mapTree.put(0,"Ponto zero");
        mapTree.put(2, "Loggan");
        mapTree.put(4, "Pereira");
        mapTree.put(5, "Oscar");
        mapTree.put(6, "Joker2");
        mapTree.put(1, "Felipe");
        mapTree.put(6, "Joker1");
        mapTree.put(3, "Leal");
        mapTree.put(5, "Oscar2");

        for(Map.Entry<Integer, String> mappingTree : mapTree.entrySet()){
            System.out.println(mappingTree);
        }

        System.out.println();
        System.out.println();

        //Linked mantém a ordem crescente de inserção
        System.out.println("========LinkedHashMap========\n");
        Map<Integer,String> mapLHash = new LinkedHashMap<>();

        mapLHash.put(0,"Ponto zero");
        mapLHash.put(2, "Loggan");
        mapLHash.put(4, "Pereira");
        mapLHash.put(5, "Oscar");
        mapLHash.put(6, "Joker2");
        mapLHash.put(1, "Felipe");
        mapLHash.put(6, "Joker1");
        mapLHash.put(3, "Leal");
        mapLHash.put(5, "Oscar2");
        mapLHash.remove(3);

        for(Map.Entry<Integer, String> mappingLHash : mapLHash.entrySet()){
            System.out.println(mappingLHash);
        }

    }

}
