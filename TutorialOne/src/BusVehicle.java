public class BusVehicle extends Vehicle{

    private String vehicleID;

    public BusVehicle() {

    }

    public BusVehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String toString() {
        return "This is a BusVehicle, with unique ID = " + vehicleID;
    }

}