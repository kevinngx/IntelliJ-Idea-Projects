import java.util.ArrayList;

public class BikeSystem {

    int numBikes;
    ArrayList<Bike> bikes = new ArrayList<>();

    public BikeSystem(int numBikes) {
        this.numBikes = numBikes;
    }

    public boolean insertBike(String bikeString) {
        //Split input string into array newBike
        String[] newBike = bikeString.split("\\|");

        //Create Bike object if the input represents a bike
        if (newBike[0].equals("Bike")) {
            Bike bike = new Bike(newBike[1], newBike[2], Integer.parseInt(newBike[3]),
                    Integer.parseInt(newBike[4]), Integer.parseInt(newBike[5]));
            bikes.add(bike);
//            inputBikes.add(bikeString);
//            models.add(newBike[2]);
//            owners.add(newBike[1]);

            //Create mountain bike object if the input represents a mountain bike
        } else if (newBike[0].equals("MTB")) {
            MountainBike mtnBike = new MountainBike(newBike[1], newBike[2], Integer.parseInt(newBike[3]),
                    Integer.parseInt(newBike[4]), Integer.parseInt(newBike[5]), Integer.parseInt(newBike[6]));
            bikes.add(mtnBike);

            //Create road bike object if the input represents a road bike
        } else if (newBike[0].equals("RB")) {
            RoadBike roadBike = new RoadBike(newBike[1], newBike[2], Integer.parseInt(newBike[3]),
                    Integer.parseInt(newBike[4]), Integer.parseInt(newBike[5]), Integer.parseInt(newBike[6]));
            bikes.add(roadBike);
        }

        return false;
    }

    public boolean bikeExists(String owner, String model) {
        boolean exists = false;
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getOwner().equals(owner) && bikes.get(i).getModel().equals(model)) {
                exists = true;
            }
        }
        return exists;
    }

    public void printSystem() {
        for (int i = 0; i < bikes.size(); i++) {
            System.out.println(bikes.get(i).toString());
        }
    }

    public void closeShop() {
        bikes.clear();
    }

    public void printServiceIntervals() {
        for (int i = 0; i < bikes.size(); i++) {
            System.out.println(String.format("%s, %s, %s",
                    bikes.get(i).getOwner(), bikes.get(i).getModel(), bikes.get(i).calculateServiceIntervals()));
        }
    }

}
