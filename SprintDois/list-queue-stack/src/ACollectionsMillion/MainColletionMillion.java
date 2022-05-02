package ACollectionsMillion;

import java.util.*;


public class MainColletionMillion {
    public static void main(String[] args) {
    /*  - Busca de um elemento
        - Inserção de um elemento no meio da coleção
        - Inserção no inicio e no final da coleção
        - Remoção de todos elementos  da coleção
        - Remoção de um elemento no meio da coleção*/

    /* Tempo para contabilizar
        double inicio = System.currentTimeMillis();
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo + "ms"); */

    List<Integer> list=new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    Set<String> setHash = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();


    int limite=1000000;
    double inicioDosTestes;
    double buscaElementoExiste;
    double buscaElementoNaoExiste;
    double inicioAposInsercaoMilhao;
    double inserMeioColecao;
    double inserInicio;
    double inserFinal;
    double remocaoTodosElem;
    double remocaoMeiosColecao;
    double fimDosTestes;
    double tempo;
    double diferencaTempo;
    

    //PERFOMANCE LIST
        System.out.println("--------Perfomance da LIST---------");
        inicioDosTestes = System.currentTimeMillis();
        for (int i=0;i<limite;i++){
            list.add(i);
        }
        inicioAposInsercaoMilhao=System.currentTimeMillis()-inicioDosTestes;
        System.out.printf("Tempo para inserção de 1 milhão de elementos: %.2fms",inicioAposInsercaoMilhao);


        //Busca de UM elemento que existe

            list.contains(560800);
            buscaElementoExiste = System.currentTimeMillis()-inicioDosTestes;
            diferencaTempo = buscaElementoExiste-inicioAposInsercaoMilhao;
            System.out.printf("\nTempo de BUSCA de UM elemento que EXISTE: %.2fms",diferencaTempo);

        //Busca de UM elemento que não existe

            list.contains(56800000);
            buscaElementoNaoExiste = System.currentTimeMillis()-inicioDosTestes;
            diferencaTempo = buscaElementoNaoExiste - buscaElementoExiste;
            System.out.printf("\nTempo de BUSCA de UM elemento que NÃO EXISTE: %.2fms",diferencaTempo);

        //Inserção de UM elemento no MEIO da coleção

            list.add(list.size()/2,500);
            inserMeioColecao = System.currentTimeMillis()-inicioDosTestes;
            diferencaTempo = inserMeioColecao-buscaElementoNaoExiste;
            System.out.printf("\nTempo de inserção no MEIO da collection: %.2fms",diferencaTempo);


        //Inserção no INICIO e no Final da coleção
             list.add(0,295);
             inserInicio=System.currentTimeMillis()-inicioDosTestes;
             diferencaTempo = inserInicio - inserMeioColecao;
             System.out.printf("\nTempo de inserção no INICIO da collection: %.2fms",diferencaTempo);


             list.add(list.size(),356);
             inserFinal=System.currentTimeMillis()-inicioDosTestes;
             diferencaTempo = inserFinal - inserInicio;
             System.out.printf("\nTempo de inserção no FINAL da collection: %.2fms",diferencaTempo);


        //Remoção de UM elemento do meio da coleção
            list.remove(list.size()/2);
            remocaoMeiosColecao=System.currentTimeMillis()-inicioDosTestes;
            diferencaTempo = remocaoMeiosColecao - inserFinal;
            System.out.printf("\nTempo de remoção de UM elem do MEIO da collection: %.2fms",diferencaTempo);


        //Remoção de TODOS os elementos da coleção
            list.clear();
            remocaoTodosElem=System.currentTimeMillis()-inicioDosTestes;
            diferencaTempo = remocaoTodosElem-remocaoMeiosColecao;
            System.out.printf("\nTempo de remoção de TODOS os elem da collection: %.2fms",diferencaTempo);


        fimDosTestes = System.currentTimeMillis();
        tempo = fimDosTestes - inicioDosTestes;
        System.out.printf("\n====== TEMPO DE TESTES DA LIST ====== %.2fms",tempo);
        inicioDosTestes=0; inicioDosTestes=0; tempo=0;
        System.out.println("\n_______________________________________________");
        //FIM TESTE


    /////////PERFOMANCE MAP

        System.out.println("--------Perfomance da MAP COM HASHMAP---------");
        inicioDosTestes = System.currentTimeMillis();

        for (int i=0;i<limite;i++){
            map.put(i+1,i);
        }

            inicioAposInsercaoMilhao=System.currentTimeMillis()-inicioDosTestes;
            System.out.printf("Tempo para inserção de 1 milhão de elementos: %.2fms",inicioAposInsercaoMilhao);


        //Busca de UM elemento que existe

        map.containsKey(500000);
            buscaElementoExiste = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = buscaElementoExiste-inicioAposInsercaoMilhao;
        System.out.printf("\nTempo de BUSCA de UM elemento que EXISTE: %.2fms",diferencaTempo);

        //Busca de UM elemento que não existe
        map.containsKey(56800000);
        buscaElementoNaoExiste = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = buscaElementoNaoExiste - buscaElementoExiste;
        System.out.printf("\nTempo de BUSCA de UM elemento que NÃO EXISTE: %.2fms",diferencaTempo);

        //Inserção de UM elemento no MEIO da coleção
        map.put(map.size()/2,5680);
        inserMeioColecao = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserMeioColecao-buscaElementoNaoExiste;
        System.out.printf("\nTempo de inserção no MEIO da collection: %.2fms",diferencaTempo);


        //Inserção no INICIO e no Final da coleção
        map.put(0,29500);
        inserInicio=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserInicio - inserMeioColecao;
        System.out.printf("\nTempo de inserção no INICIO da collection: %.2fms",diferencaTempo);


        map.put(map.size(),356);
        inserFinal=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserFinal - inserInicio;
        System.out.printf("\nTempo de inserção no FINAL da collection: %.2fms",diferencaTempo);


        //Remoção de UM elemento do meio da coleção
        map.remove(580000);
        remocaoMeiosColecao=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = remocaoMeiosColecao - inserFinal;
        System.out.printf("\nTempo de remoção de TODOS os elem da collection: %.2fms",diferencaTempo);


        //Remoção de TODOS os elementos da coleção
        map.clear();
        remocaoTodosElem=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = remocaoTodosElem-remocaoMeiosColecao;
        System.out.printf("\nTempo de remoção de TODOS os elem da collection: %.2fms",diferencaTempo);


        fimDosTestes = System.currentTimeMillis();
        tempo = fimDosTestes - inicioDosTestes;
        System.out.printf("\n====== TEMPO DE TESTES DO MAP _ HASHMAP ====== %.2fms",tempo);
        inicioDosTestes=0; inicioDosTestes=0; tempo=0;
        System.out.println("\n_______________________________________________");
        //FIM TESTE

/////////PERFOMANCE STACK

        System.out.println("--------Perfomance do STACK---------");
        inicioDosTestes = System.currentTimeMillis();

        for (int i=0;i<limite;i++){
            stack.add(i);
        }

        inicioAposInsercaoMilhao=System.currentTimeMillis()-inicioDosTestes;
        System.out.printf("Tempo para inserção de 1 milhão de elementos: %.2fms",inicioAposInsercaoMilhao);


        //Busca de UM elemento que existe

        stack.search(500000);
        buscaElementoExiste = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = buscaElementoExiste-inicioAposInsercaoMilhao;
        System.out.printf("\nTempo de BUSCA de UM elemento que EXISTE: %.2fms",diferencaTempo);

        //Busca de UM elemento que não existe
        stack.search(56800000);
        buscaElementoNaoExiste = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = buscaElementoNaoExiste - buscaElementoExiste;
        System.out.printf("\nTempo de BUSCA de UM elemento que NÃO EXISTE: %.2fms",diferencaTempo);

        //Inserção de UM elemento no MEIO da coleção
        stack.add(stack.size()/2,25);
        inserMeioColecao = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserMeioColecao-buscaElementoNaoExiste;
        System.out.printf("\nTempo de inserção no MEIO da collection: %.2fms",diferencaTempo);


        //Inserção no INICIO e no Final da coleção
        stack.add(0,29500);
        inserInicio=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserInicio - inserMeioColecao;
        System.out.printf("\nTempo de inserção no INICIO da collection: %.2fms",diferencaTempo);


        stack.add(stack.size(),356);
        inserFinal=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserFinal - inserInicio;
        System.out.printf("\nTempo de inserção no FINAL da collection: %.2fms",diferencaTempo);


        //Remoção de UM elemento do meio da coleção
        stack.remove(580000);
        remocaoMeiosColecao=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = remocaoMeiosColecao - inserFinal;
        System.out.printf("\nTempo de remoção de UM elem do MEIO da collection: %.2fms",diferencaTempo);


        //Remoção de TODOS os elementos da coleção
        stack.clear();
        remocaoTodosElem=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = remocaoTodosElem-remocaoMeiosColecao;
        System.out.printf("\nTempo de remoção de TODOS os elem da collection: %.2fms",diferencaTempo);


        fimDosTestes = System.currentTimeMillis();
        tempo = fimDosTestes - inicioDosTestes;
        System.out.printf("\n====== TEMPO DE TESTES STACK ====== %.2fms",tempo);
        inicioDosTestes=0; inicioDosTestes=0; tempo=0;
        System.out.println("\n_______________________________________________");
        //FIM TESTE


/////////PERFOMANCE QUEUE - FIRST IN - FIRST OUT

        System.out.println("--------Perfomance da QUEUE---------");
        inicioDosTestes = System.currentTimeMillis();

        for (int i=0;i<limite;i++){
            queue.add(i);
        }

        inicioAposInsercaoMilhao=System.currentTimeMillis()-inicioDosTestes;
        System.out.printf("Tempo para inserção de 1 milhão de elementos: %.2fms",inicioAposInsercaoMilhao);


        //Busca de UM elemento que existe

        queue.contains(500000);
        buscaElementoExiste = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = buscaElementoExiste-inicioAposInsercaoMilhao;
        System.out.printf("\nTempo de BUSCA de UM elemento que EXISTE: %.2fms",diferencaTempo);

        //Busca de UM elemento que não existe
        queue.contains(56800000);
        buscaElementoNaoExiste = System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = buscaElementoNaoExiste - buscaElementoExiste;
        System.out.printf("\nTempo de BUSCA de UM elemento que NÃO EXISTE: %.2fms",diferencaTempo);


        //Inserção no Final da coleção
        inserInicio=System.currentTimeMillis()-inicioDosTestes;
        queue.add(29500);
        diferencaTempo = inserInicio - buscaElementoNaoExiste;
        System.out.printf("\nTempo de inserção no INICIO da collection: %.2fms",diferencaTempo);


        map.put(map.size(),356);
        inserFinal=System.currentTimeMillis()-inicioDosTestes;
        diferencaTempo = inserFinal - inserInicio;
        System.out.printf("\nTempo de inserção no FINAL da collection: %.2fms",diferencaTempo);


        //Remoção de TODOS os elementos da coleção
        remocaoTodosElem=System.currentTimeMillis()-inicioDosTestes;
        queue.clear();
        diferencaTempo = remocaoTodosElem-inserFinal;
        System.out.printf("\nTempo de remoção de TODOS os elem da collection: %.2fms",diferencaTempo);


        fimDosTestes = System.currentTimeMillis();
        tempo = fimDosTestes - inicioDosTestes;
        System.out.printf("\n====== TEMPO DE TESTES DO QUEUE ====== %.2fms",tempo);
        inicioDosTestes=0; inicioDosTestes=0; tempo=0;
        System.out.println("\n_______________________________________________");
        //FIM TESTE


    }



}

