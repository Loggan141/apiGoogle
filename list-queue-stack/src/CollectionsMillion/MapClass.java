package CollectionsMillion;

import java.util.*;

public class MapClass {
    private Map<Integer, Integer> map;

    public void createHashMap(){this.map=new HashMap<>();}
    public void createLinkedHashMap(){this.map=new LinkedHashMap<>();}
    public void createTreeMap(){this.map=new TreeMap<>();}

    public void createOneMillion(){
        for(int i = 0; i< 1000000; i++){
          this.map.put(i+2,i);
        } 
    }

    public void getSizeMap(){
        System.out.printf("\nThe map's size : %d elements",this.map.size());
    }

    public void printEveryMap(){
        for(Map.Entry<Integer, Integer> entry : this.map.entrySet()){
            System.out.println("["+entry.getKey()+"] - "+ entry.getValue());
        }
    }

    public void searchByKeyMap(int key){
        double begin = System.nanoTime();
        this.map.containsKey(key);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nSearching time by key : %.2f ns",finalTime);

    }

    public void clearMap(){
        double begin = System.nanoTime();
        this.map.clear();
        double finalTime=System.nanoTime()-begin;

        System.out.printf("\nClear time : %.2f ns",finalTime);;
    }

    public void addOnMap(int index, int element){
        this.map.put(index, element);
    }

    public void addOnFirstMap(int element){
        double begin = System.nanoTime();
        this.map.put(0,element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time on the first index: %.2f ns",finalTime);
    }

    public void addOnLastMap(int element){
        double begin = System.nanoTime();
        this.map.put(map.size(),element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time on the last index: %.2f ns",finalTime);
    }

    public void removeFromMap(int element){
        double begin = System.nanoTime();
        this.map.remove(element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nRemoving time: %2.2f ns",finalTime);
    }

    public void addOnMiddle(int element){
        double begin = System.nanoTime();
        this.map.put(map.size()/2, element);
        double finalTime=System.nanoTime()-begin;
        System.out.printf("\nInsertion time on the midle index: %2.2f ns",finalTime);
    }


}
