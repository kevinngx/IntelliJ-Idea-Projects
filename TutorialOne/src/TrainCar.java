public class TrainCar extends RailVehicle {

    private boolean driverInCar;
    private String vehicleID;

    public TrainCar() {

    }

    public TrainCar(String vehicleID) {
        super(vehicleID);
    }

    public TrainCar(String vehicleID, boolean driverInCar) {
        super(vehicleID);
        this.driverInCar = driverInCar;
    }

    public String toString() {
        if (driverInCar == false) {
            return "This is a TrainCar, in chain " + vehicleID + ", with no driver";
        } else {
            return "This is a TrainCar, in chain " + vehicleID + ", with driver";
        }
    }

}