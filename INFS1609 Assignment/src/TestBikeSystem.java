public class TestBikeSystem {

    public static void main(String[] args) {
        BikeSystem bs = new BikeSystem(20);
        bs.insertBike("Bike|Emily|Spinner|14|0|1");
        bs.insertBike("MTB|Kirstin|Explorer|26|10|200|120");
        bs.insertBike("RB|Alexander|Roadster|27|12|100|5");
        bs.insertBike("Bike|Caroline|Toddler|10|0|1");
        bs.insertBike("MTB|Anthony|Reign|27|10|500|170");
        bs.insertBike("RB|George|Thunder|29|7|1000|4");
        bs.insertBike("Bike|Sharon|Alley|24|5|20");
        bs.insertBike("MTB|Susan|Nomad|29|11|400|180");
        bs.insertBike("RB|Micahel|Highway|26|15|750|4");
        bs.printSystem();
    }
}
