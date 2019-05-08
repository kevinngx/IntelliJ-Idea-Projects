public class RoadBike extends Bike{

    private int reflectorsFitted;

    public RoadBike(String owner, String model, int wheelDiameter, int gears, int kmsRidden, int reflectorsFitted) {
        super(owner, model, wheelDiameter, gears, kmsRidden);
        this.reflectorsFitted = reflectorsFitted;
    }

    public int getReflectorsFitted() {
        return reflectorsFitted;
    }

    public void setReflectorsFitted(int reflectorsFitted) {
        this.reflectorsFitted = reflectorsFitted;
    }

    public int calculateServiceIntervals() {
        return getKmsRidden() * reflectorsFitted;
    }

    @Override
    public String toString() {
        return String.format("RB|%s|%s|%s|%s|%s|%s",
                super.getOwner(), super.getModel(), super.getWheelDiameter(), super.getGears(), super.getKmsRidden(), reflectorsFitted);
    }
}
