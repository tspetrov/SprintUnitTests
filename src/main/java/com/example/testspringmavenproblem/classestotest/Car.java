public class Car {

    int carWeight = 1000;

    public void driveCar(String driverName) {
        System.out.println("Car is driven by " + driverName);
    }

    public void fuelUplift(int quantity) {
        System.out.println("Fuel uplifted - " + quantity + " LTR");
    }

    public int getCarWeight() {
        return this.carWeight;
    }
}
