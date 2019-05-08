package T01E01;

public class TrainCar extends Vehicle {
    boolean hasDriver;

    public TrainCar(String id, boolean hasDriver) {
        super(id);
        this.hasDriver = hasDriver;
    }

    public String toString() {
        String driverText;
        if (hasDriver) {
            driverText = "driver";
        } else {
            driverText = "no driver";
        }
        return String.format("This is a TrainCar, in chain %s, with %s", id, driverText);
    }

}
