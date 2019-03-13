public class MessageLoop implements Runnable {

    String filename;
    private int sleepTime;


    public MessageLoop(String filename, int sleepTime) {
        this.filename = filename;
        this.sleepTime = sleepTime;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(sleepTime);
                Helper.writeToFile(filename, "Hello, World");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }

    }

}
