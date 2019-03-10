/**
 *  This class is responsible for writing Hello World to the respective text files.
 *  Constructor parameter (filename - name of the file that it is being written to, timeAsleep - how long the thread should be asleep for)
 *  Remember what you need to add in this class in order for it to be run in a thread
 */

public class MessageLoop implements Runnable {
    private String filename;
    private long timeAsleep;

    public MessageLoop(String filename, long timeAsleep){
        this.filename = filename;
        this.timeAsleep = timeAsleep;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(timeAsleep);
                Helper.writeToFile(filename, "Hello World");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread  " + filename + " interrupted");
        }
    }
}