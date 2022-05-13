package SomeGeneric.service;

import java.util.List;

public class RentalService<T> {

    private List<T> availableObjects;

    public RentalService(List<T> availableObjects){
        this.availableObjects=availableObjects;
    }

    /**
     **Search for an object and rent it to the client
     */
    public T searchObjectAvailable(){
        System.out.println("Searching for available...");
        T object = availableObjects.remove(0);
        System.out.println("Renting an object..."+object);
        System.out.println("Updating...  Showing available objects :");
        System.out.println(availableObjects);
        return object;
    }

    /**
     **Return an object to the store from client
     */
    public void returningObject(T object){
        System.out.println("Returning object: "+object);
        availableObjects.add(object);
        System.out.println("Updating...  Showing available objects :");
        System.out.println(availableObjects);

    }

}
