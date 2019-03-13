public class Vehicle {

    private String vehicleID;

    public Vehicle() {

    }

    public Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleID() {
        return this.vehicleID;
    }

    public String toString() {
        return "This is a Vehicle, with unique ID = " + vehicleID;
    }

}