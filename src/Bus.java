public class Bus {
    private String name;
    private final float fuel_volume = 40f;
    private final float fuel_consumption=7.5f;
    private  float real_fuel_volume = 40f;
    private FuelStation fuelStation;

    public Bus(String name, FuelStation fuelStation) {
        this.name = name;
        this.fuelStation = fuelStation;
    }

    public Bus(String name, float real_fuel_volume) {
        this.name = name;
        this.real_fuel_volume = real_fuel_volume;
    }

    public void drive(){
        System.out.println("Поехал "+this.toString());

        while (real_fuel_volume>=7.5f){
            try {
                Thread.sleep(3000);
                real_fuel_volume-=fuel_consumption;
                System.out.println("У " + this.toString() + "осталось топлива" + real_fuel_volume);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                ", real_fuel_volume=" + real_fuel_volume +
                '}';
    }
}
