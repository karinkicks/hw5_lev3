public class Car {
    private String name;
    private final float fuel_volume = 20f;
    private final float fuel_consumption=2.5f;
    private  float real_fuel_volume = 20f;
    private FuelStation fuelStation;

    public Car(String name, FuelStation fuelStation) {
        this.name = name;
        this.fuelStation = fuelStation;
    }


    public void drive(){
        System.out.println("Поехал "+this.toString());
        try {
            while (real_fuel_volume>=2.5f){
                Thread.sleep(3000);
                real_fuel_volume-=fuel_consumption;
                System.out.println("У " + this.toString() + " осталось топлива" + real_fuel_volume);
            }
            System.out.println("У " + this.toString() + " недостаточно топлива, чтобы продолжить движение");
            float refuel = fuelStation.refuel(fuel_volume-real_fuel_volume);
            if(refuel==0f){
                System.out.println("Столько бензина нет на станции");
                return;
            }
            real_fuel_volume+=refuel;
            System.out.println("После заправки осталось топлива " + this.toString());
            drive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", real_fuel_volume=" + real_fuel_volume +
                '}';
    }
}
