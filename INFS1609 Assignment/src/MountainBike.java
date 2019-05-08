public class MountainBike extends Bike{

    private int suspensionDepth;

    public MountainBike(String owner, String model, int wheelDiameter, int gears, int kmsRidden, int suspensionDepth) {
        super(owner, model, wheelDiameter, gears, kmsRidden);
        this.suspensionDepth = suspensionDepth;
    }

    public int getSuspensionDepth() {
        return suspensionDepth;
    }

    public void setSuspensionDepth(int suspensionDepth) {
        this.suspensionDepth = suspensionDepth;
    }

    public int calculateServiceIntervals() {
        return getWheelDiameter() * getGears() - suspensionDepth;
    }

    @Override
    public String toString() {
        return String.format("MTB|%s|%s|%s|%s|%s|%s",
                super.getOwner(), super.getModel(), super.getWheelDiameter(), super.getGears(), super.getKmsRidden(), suspensionDepth);
    }
}
