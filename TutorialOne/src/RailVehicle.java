public class RailVehicle extends Vehicle {

    private String vehicleID;

    public RailVehicle() {

    }

    public RailVehicle(String vehicleID) {
        super(vehicleID);
    }

    public String toString() {
        return "This is a RailVehicle, with unique ID = " + vehicleID;
    }

}