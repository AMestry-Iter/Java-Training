package Day_3_OOPSnCollectionsContinue;

public class Car extends Vehicle implements Drivable{
    private int horsePower;

    public Car(String brand, String model, int year, int horsePower) {
        super(brand, model, year);
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        System.out.println("Car started: " + getBrand() + " " + getModel());
    }

    @Override
    public void accelerate() {
        System.out.println("Car accelerated: " + getBrand() + " " + getModel());
    }

    @Override
    public void stop() {
        System.out.println("Car stopped: " + getBrand() + " " + getModel());
    }

    @Override
    public double calculateMaintenanceCost() {
        return 5000+(horsePower*20);
    }


}
