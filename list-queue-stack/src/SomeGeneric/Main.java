package SomeGeneric;

import SomeGeneric.dominio.Boat;
import SomeGeneric.dominio.Car;
import SomeGeneric.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Boat> b1 = new ArrayList<>(List.of(new Boat("Toyota"), new Boat("Honda"), new Boat("Suzuki")));
        List<Car> c1 = new ArrayList<>(List.of(new Car("Toyota"), new Car("Honda"), new Car("Suzuki")));

        RentalService<Boat> rentalServiceBoat=new RentalService<>(b1);
        RentalService<Car>  rentalServiceCar=new RentalService<>(c1);

        Car carro = rentalServiceCar.searchObjectAvailable();
        System.out.println();
        rentalServiceBoat.searchObjectAvailable();


    }
}
