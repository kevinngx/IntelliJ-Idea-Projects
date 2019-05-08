package T01E01;

public class Vehicle {
    String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public String toString() {
        return String.format("This is a Vehicle, with unique ID = %s", id);
    }

}
