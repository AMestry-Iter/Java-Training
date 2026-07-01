package Day_3_OOPSnCollectionsContinue;

public class Motorcycle extends Vehicle implements Drivable{
    private int engineCC;

    public Motorcycle(String brand, String model, int year, int engineCC) {
        super(brand, model, year);
        this.engineCC = engineCC;
    }

    @Override
    public void start() {
        System.out.println("Bike started: " + getBrand() + " " + getModel());
    }

    @Override
    public void accelerate() {
        System.out.println("Bike accelerated: " + getBrand() + " " + getModel());
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped: " + getBrand() + " " + getModel());
    }

    @Override
    public double calculateMaintenanceCost() {
        return 5000+(engineCC*5);
    }
}
