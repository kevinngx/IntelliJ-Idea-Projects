public class MetroCar extends RailVehicle {
    private String routePlan;

    public MetroCar() {

    }

    public MetroCar(String vehicleID) {
        super(vehicleID);
    }

    public String toString() {
        return "This is a MetroCar, automated under route plan = " + routePlan;
    }

}