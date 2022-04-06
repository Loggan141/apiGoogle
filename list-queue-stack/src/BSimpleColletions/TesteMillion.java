package BSimpleColletions;

public class TesteMillion {
    public static int ONE_MILLION=1000000;

    public static void main(String[] args) {


    /*- Busca de um elemento
        - Inserção de um elemento no meio da coleção
        - Inserção no inicio e no final da coleção
        - Remoção de um elemento no meio da coleção
        - Remoção de todos elementos  da coleção*/

    System.out.print("----TESTANDO LIST ARRAYLIST----\n");
        ListClass list1=new ListClass();
        list1.creatingArrayList();
        list1.creatingListOneMillion();
        list1.getSizeList();
        list1.searchByElementList(25500);
        list1.addOnFirstList(56);
        list1.addOnLastList(25);
        list1.getSizeList();
        list1.removeFromList(25);
        list1.getSizeList();
        list1.addOnMiddle(250);
        list1.getSizeList();
        list1.getLista(50);
        list1.clearList();
        list1.getSizeList();
        System.out.println();

    System.out.print("\n\n----TESTANDO LIST LINKEDLIST----");
        ListClass list2=new ListClass();
        list2.creatingLinkedList();
        list2.creatingListOneMillion();
        list2.getSizeList();
        list2.searchByElementList(25500);
        list2.addOnFirstList(56);
        list2.addOnLastList(25);
        list2.getSizeList();
        list2.removeFromList(25);
        list2.getSizeList();
        list2.addOnMiddle(250);
        list2.getSizeList();
        list2.getLista(50);
        list2.clearList();
        list2.getSizeList();
        System.out.println();



    System.out.print("\n\n----TESTANDO SET LINKEDHASHSET----\n");
        SetClass setLinkHash = new SetClass();
        setLinkHash.creatingLinkedHashSet();
        setLinkHash.creatingOneMillion();
        setLinkHash.getSetSize();
        setLinkHash.searchByElementSet(25500);
        setLinkHash.addOnSet(56);
        setLinkHash.getSetSize();
        setLinkHash.removeFromSet(25);
        setLinkHash.getSetById(26);
        setLinkHash.getSetSize();
        setLinkHash.clearSet();
        setLinkHash.getSetSize();
        System.out.println();


    System.out.print("\n\n----TESTANDO SET HASHSET----\n");
        SetClass setHash = new SetClass();
        setHash.creatingHashSet();
        setHash.creatingOneMillion();
        setHash.getSetSize();
        setHash.searchByElementSet(25500);
        setHash.addOnSet(56);
        setHash.getSetSize();
        setHash.removeFromSet(25);
        setHash.getSetById(26);
        setHash.getSetSize();
        setHash.clearSet();
        setHash.getSetSize();
        System.out.println();


    System.out.print("\n\n----TESTANDO SET TREESET----\n");
        SetClass setTreeHash = new SetClass();
        setTreeHash.creatingTreeSet();
        setTreeHash.creatingOneMillion();
        setTreeHash.getSetSize();
        setTreeHash.searchByElementSet(25500);
        setTreeHash.addOnSet(56);
        setTreeHash.getSetSize();
        setTreeHash.removeFromSet(25);
        setTreeHash.getSetById(26);
        setTreeHash.getSetSize();
        setTreeHash.clearSet();
        setTreeHash.getSetSize();
        System.out.println();

    System.out.print("\n\n----TESTANDO MAP HASHMAP----\n");
        MapClass hashMap = new MapClass();
        hashMap.createHashMap();
        hashMap.createOneMillion();
        hashMap.getSizeMap();
        hashMap.searchByKeyMap(500000);
        hashMap.addOnFirstMap(5);
        hashMap.getSizeMap();
        hashMap.addOnMiddle(8);
        hashMap.getSizeMap();
        hashMap.addOnMiddle(50);
        hashMap.getSizeMap();
        hashMap.removeFromMap(36);
        hashMap.getSizeMap();
        hashMap.clearMap();
        hashMap.getSizeMap();

    System.out.print("\n\n----TESTANDO MAP LINKEDHASHMAP----\n");
        MapClass linkedHashMap = new MapClass();

        linkedHashMap.createLinkedHashMap();
        linkedHashMap.createOneMillion();
        linkedHashMap.getSizeMap();
        linkedHashMap.searchByKeyMap(500000);
        linkedHashMap.addOnFirstMap(5);
        linkedHashMap.getSizeMap();
        linkedHashMap.addOnMiddle(8);
        linkedHashMap.getSizeMap();
        linkedHashMap.addOnMiddle(50);
        linkedHashMap.getSizeMap();
        linkedHashMap.removeFromMap(36);
        linkedHashMap.getSizeMap();
        linkedHashMap.clearMap();
        linkedHashMap.getSizeMap();

    System.out.print("\n\n----TESTANDO MAP TREEMAP----\n");
        MapClass treeMap = new MapClass();

        treeMap.createTreeMap();
        treeMap.createOneMillion();
        treeMap.getSizeMap();
        treeMap.searchByKeyMap(500000);
        treeMap.addOnFirstMap(5);
        treeMap.getSizeMap();
        treeMap.addOnMiddle(8);
        treeMap.getSizeMap();
        treeMap.addOnMiddle(50);
        treeMap.getSizeMap();
        treeMap.removeFromMap(36);
        treeMap.getSizeMap();
        treeMap.clearMap();
        treeMap.getSizeMap();

    /* Diferenças entre ArrayList e LinkedList
           performance nos metodos add, remove, get e set
           elementos duplicados
           espaço inicial e maximo
           */
        System.out.println("\n\nDiferenças entre ArrayList e LinkedList\n" +
                "performance nos metodos add, remove, get e set\n" +
                "elementos duplicados\n" +
                "espaço inicial e maximo\n");

                System.out.print("---Insertion ArrayList---");
                list1.getSizeList();
                list1.creatingListOneMillion();
                list1.getSizeList();
                list1.getLista(50000);
                list1.setList(5,1245);
                list1.getSizeList();
                list1.addOnLista(0);
                list1.getSizeList();
                System.out.println("\n________________________________");

                System.out.print("\n---Insertion LinkedList---");
                list2.getSizeList();
                list2.creatingListOneMillion();
                list2.getSizeList();
                list2.getLista(50000);
                list2.setList(5,1245);
                list2.getSizeList();
                list2.addOnLista(0);
                list2.getSizeList();

                System.out.println("\n________________________________");


                System.out.print("\nRemove ArrayList");
                list1.removeFromList(500000);
                list1.getSizeList();
                System.out.print("\nRemove LinkedList");
                list2.removeFromList(500000);
                list2.getSizeList();
                System.out.println("\n________________________________");


    /* Diferenças entre LinkedHashSet, HashSet e TreeSet
            elementos duplicados
            performance  e ordenação
            espaço inicial e maximo
            */

        System.out.println("\n==HashSet==");
        setHash.addOnSetNoPrint(8);
        setHash.addOnSetNoPrint(3);
        setHash.addOnSetNoPrint(4);
        setHash.addOnSetNoPrint(6);
        setHash.addOnSetNoPrint(7);
        setHash.addOnSetNoPrint(5);
        setHash.addOnSetNoPrint(6);
        setHash.getSetSize();
        System.out.println(setHash);
        System.out.println("Ordena os elementos conforme a HASH.");

        System.out.println("\n==+++++==");

        System.out.println("\n==LinkedHashSet==");
        setLinkHash.addOnSetNoPrint(8);
        setLinkHash.addOnSetNoPrint(3);
        setLinkHash.addOnSetNoPrint(4);
        setLinkHash.addOnSetNoPrint(6);
        setLinkHash.addOnSetNoPrint(7);
        setLinkHash.addOnSetNoPrint(5);
        setLinkHash.addOnSetNoPrint(6);
        setLinkHash.getSetSize();
        System.out.println(setLinkHash);
        System.out.println("Ordena os elementos conforme a ordem de inserção.");


        System.out.println("\n==+++++==");

        System.out.println("\n==TreeSet==");
        setTreeHash.addOnSetNoPrint(8);
        setTreeHash.addOnSetNoPrint(3);
        setTreeHash.addOnSetNoPrint(4);
        setTreeHash.addOnSetNoPrint(6);
        setTreeHash.addOnSetNoPrint(7);
        setTreeHash.addOnSetNoPrint(5);
        setTreeHash.addOnSetNoPrint(6);
        setTreeHash.getSetSize();
        System.out.println(setTreeHash);
        System.out.println("Ordena os elementos conforme a ordem de números.");

        System.out.println("Nenhum SET aceita elemento duplicado.");
        System.out.println("\n==+++++==");


    /* Diferenças entre HashMap, LinkedHashMap e TreeMap
           elementos duplicados
           performance  e ordenação
           espaço inicial e maximo
           */

        System.out.println("\n==HashMAP==");
        hashMap.addOnMap(8,5);
        hashMap.addOnMap(6,5);
        hashMap.addOnMap(6,5);
        hashMap.addOnMap(4,2);
        hashMap.addOnMap(16,3);
        hashMap.addOnMap(62,9);
        hashMap.addOnMap(60,50);
        hashMap.printEveryMap();
        hashMap.getSizeMap();

        System.out.println("\nOrdena os elementos conforme a INDEX(KEY).");

        System.out.println("\n==+++++==");

        System.out.println("\n==LinkedHashMap==");
        linkedHashMap.addOnMap(8,5);
        linkedHashMap.addOnMap(6,5);
        linkedHashMap.addOnMap(6,5);
        linkedHashMap.addOnMap(4,2);
        linkedHashMap.addOnMap(16,3);
        linkedHashMap.addOnMap(62,9);
        linkedHashMap.addOnMap(60,50);
        linkedHashMap.printEveryMap();
        linkedHashMap.getSizeMap();

        System.out.println("\nOrdena os elementos conforme a ordem de inserção.");


        System.out.println("\n==+++++==");

        System.out.println("\n==TreeMAP==");

        treeMap.addOnMap(8,5);
        treeMap.addOnMap(6,5);
        treeMap.addOnMap(6,5);
        treeMap.addOnMap(4,2);
        treeMap.addOnMap(16,3);
        treeMap.addOnMap(62,9);
        treeMap.addOnMap(60,50);
        treeMap.printEveryMap();
        treeMap.getSizeMap();

        System.out.println("\nOrdena os elementos conforme a ordem de números.");

        System.out.println("Nenhum MAP aceita elementos duplicados CONFORME INDEX(KEY).");
        System.out.println("\n==+++++==");

    }
}
