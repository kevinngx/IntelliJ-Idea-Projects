package T01E01;

public class MetroCar extends RailVehicle{


    public MetroCar(String id) {
        super(id);
    }

    public String toString() {
        return String.format("This is a MetroVehicle, automated under route plan %s", id);
    }
}
