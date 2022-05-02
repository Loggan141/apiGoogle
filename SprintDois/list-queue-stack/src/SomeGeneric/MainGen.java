package SomeGeneric;

import SomeGeneric.dominio.Boat;
import SomeGeneric.dominio.Car;
import SomeGeneric.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class MainGen {
    public static void main(String[] args) {
        List<Boat> b1 = new ArrayList<>(List.of(new Boat("CARAVELLE"),
                                                new Boat("KAWASAKI"),
                                                new Boat("QUICKSILVER")));


        List<Car> c1 = new ArrayList<>(List.of(new Car("Toyota"),
                                               new Car("Honda"),
                                               new Car("Suzuki")));


        RentalService<Boat> rentalServiceBoat=new RentalService<>(b1);
        RentalService<Car>  rentalServiceCar=new RentalService<>(c1);

        System.out.println("------CARS------");
        Car carro = rentalServiceCar.searchObjectAvailable();
        System.out.println();
        rentalServiceCar.returningObject(carro);
        System.out.println("-------------------------------------------");

        System.out.println("------BOAT------");
        Boat boat = rentalServiceBoat.searchObjectAvailable();
        System.out.println();
        rentalServiceBoat.returningObject(boat);


    }
}
