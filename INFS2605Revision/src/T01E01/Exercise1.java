package T01E01;

import java.util.ArrayList;

public class Exercise1 {
    // This is just for your testing - we will run your classes against our own tests
    // Make sure you have the correct toString for all classes
    public static void main (String[] args){

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("E7BC"));
        vehicles.add(new Vehicle("BB77"));
        vehicles.add(new RailVehicle("120B"));
        vehicles.add(new TrainCar("721X5", false));
        vehicles.add(new TrainCar("721X5", false));
        vehicles.add(new TrainCar("721X5", true));
        vehicles.add(new MetroCar("47Q"));
        vehicles.add(new MetroCar("47R"));
        vehicles.add(new BusVehicle("12AA"));

        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle.toString());
        }


    }
}