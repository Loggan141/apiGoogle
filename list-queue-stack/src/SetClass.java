import java.sql.SQLOutput;
import java.util.*;

public class SetClass {
    private Set<Integer> set;

    public void creatingLinkedHashSet(){ this.set = new LinkedHashSet<>();    }
    public void creatingHashSet(){this.set=new HashSet<>();}
    public void creatingTreeSet(){this.set = new TreeSet<>();}



    public void creatingOneMillion(){
        double begin = System.nanoTime();
        for (int i=0;i<TesteMillion.ONE_MILLION;i++){
            this.set.add(i);
        }
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nTime taken to create 1 million of elements : %.2f ns",finalTime);
    }

    public void searchByElementSet(int element){
        double begin = System.nanoTime();
        this.set.contains(element);
        double finalTime=System.nanoTime()-begin;

        System.out.printf("\nSearching time by element : %.2f ns",finalTime);

    }


    public void clearSet(){
        double begin = System.nanoTime();
        this.set.clear();
        double finalTime=System.nanoTime()-begin;

        System.out.printf("\nClear time : %.2f ns",finalTime);;
    }

    public void addOnSet(int element){
        double begin = System.nanoTime();
        this.set.add(element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time : %.2f ns",finalTime);
    }
    public void addOnSetNoPrint(int element){
        this.set.add(element);
        }

    public void removeFromSet(int element){
        double begin = System.nanoTime();
        this.set.remove(element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nRemoving time: %2.2f ns",finalTime);
    }

    public void getSetSize(){
        System.out.printf("\nSet's size : %d elements",this.set.size());
    }

    public void getSetById(int id){
        if (set.contains(id)){
            System.out.printf("\nID has Founded: %d",id);
        }else{
            System.out.print("\nThere's no such element with this ID.");
        }
    }
    @Override
    public String toString() {
        return " { "+this.set+" }";
    }

}
