import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        Car car1 = new Car("1", fuelStation);
        Car car2 = new Car("2", fuelStation);
        Car car3 = new Car("3", fuelStation);
        Truck truck1 = new Truck("1", fuelStation);
        Truck truck2 = new Truck("1", fuelStation);
        Truck truck3 = new Truck("1", fuelStation);
        Bus bus1 = new Bus("1", fuelStation);
        Bus bus2 = new Bus("1", fuelStation);
        Bus bus3 = new Bus("1", fuelStation);

        ExecutorService executorService = Executors.newFixedThreadPool(9);

        executorService.execute(()->car1.drive());
        //executorService.execute(()->car2.drive());
        //executorService.execute(()->car3.drive());
        //executorService.execute(()->truck1.drive());
        //executorService.execute(()->truck2.drive());
        //executorService.execute(()->truck3.drive());
        //executorService.execute(()->bus1.drive());
       // executorService.execute(()->bus2.drive());
        //executorService.execute(()->bus3.drive());

        executorService.shutdown();
    }
}
