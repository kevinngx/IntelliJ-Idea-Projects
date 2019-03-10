import java.util.UUID;

public class AstroDroid implements Runnable {
    private String name;
    private long timeAsleep;

    public AstroDroid(String name, long timeAsleep) {
        this.name = name;
        this.timeAsleep = timeAsleep;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(timeAsleep);
                UUID newUUID = UUID.randomUUID();
                String nextLine = (
                        "AstroDroid " + this.name
                        + " produced UUID = " + newUUID
                );
                TwoSixZeroFiveHelper.replaceFileContents("temp.txt", nextLine);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted!");
        }
    }

}
