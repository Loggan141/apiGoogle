import java.sql.SQLOutput;
import java.util.*;

public class ListClass {

    private List<Integer> lista;

//ArrayListMethods
    public void creatingArrayList(){
        this.lista = new ArrayList<>();
    }
    public void creatingLinkedList(){
        this.lista = new LinkedList<>();
    }

    
    public void creatingListOneMillion(){
       double begin = System.nanoTime();
       for (int i=0;i<TesteMillion.ONE_MILLION;i++){
                 this.lista.add(i);
                                }

       double finalTime=System.nanoTime()-begin;
       System.out.printf("\nTime taken to create 1 million of elements : %.2f ns",finalTime);
    }

    public void searchByElementList(int element){
        double begin = System.nanoTime();
        this.lista.contains(element);
        double finalTime=System.nanoTime()-begin;
     
        System.out.printf("\nSearching time by element : %.2f ns",finalTime);

    }

    public void clearList(){
        double begin = System.nanoTime();
        this.lista.clear();
        double finalTime=System.nanoTime()-begin;

        System.out.printf("\nClear time : %.2f ns",finalTime);;
    }

     public void addOnFirstList(int element){
        double begin = System.nanoTime();
        this.lista.add(0,element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time on the first index: %.2f ns",finalTime);
    }

    public void addOnLastList(int element){
        double begin = System.nanoTime();
        this.lista.add(lista.size(),element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time on the last index: %.2f ns",finalTime);
    }

    public void addOnMiddle(int element){
        double begin = System.nanoTime();
        this.lista.add(lista.size(), element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time on the midle index: %2.2f ns",finalTime);
    }

    public void removeFromList(int element){
        double begin = System.nanoTime();
        int indexList = this.lista.indexOf(element);
        this.lista.remove(indexList);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nRemoving time: %2.2f ns",finalTime);
    }

    public void getLista(int index) {
        double begin = System.nanoTime();
        lista.get(index);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nGet in the index :%d   it took %2.2f ns",index, finalTime);
        }

    public void addOnLista(int element){
        double begin = System.nanoTime();
        this.lista.add(element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time : %2.2f ns",finalTime);

    }

    //setlist replace an element at a specified place
    public void setList(int ind, int element){
        double begin = System.nanoTime();
        this.lista.set(ind, element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nReplacing time : %2.2f ns, at index> %d",finalTime,ind);
    }

    public void getSizeList(){
        System.out.printf("\nList's size : %d elements",this.lista.size());
    }


}
