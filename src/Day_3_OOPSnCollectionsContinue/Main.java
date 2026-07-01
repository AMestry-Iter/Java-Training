package Day_3_OOPSnCollectionsContinue;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("BMW", "330i", 2024, 255),
                new Motorcycle("Suzuki", "Ninja", 2024, 640)
        };

        for(Vehicle v:vehicles){
            System.out.println("\nMaintenance Cost: " + v.calculateMaintenanceCost());

            Drivable d = (Drivable) v;
            d.start();
            d.accelerate();
            d.stop();
        }
    }
}
