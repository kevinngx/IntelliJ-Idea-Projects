package T01E01;

public class BusVehicle extends Vehicle{

    public BusVehicle(String id) {
        super(id);
    }

    public String toString() {
        return String.format("This is a BusVehicle, with unique ID = %s", id);
    }

}
