import java.lang.annotation.Target;

public class MyThread extends Thread {

    private int threadID;
    private TargetClass target;

    public MyThread(int threadID, TargetClass target) {
        this.threadID = threadID;
        this.target = target;
    }

    @Override
    public void run() {
        int iterations = 5;

        synchronized (target) {
            try {
                for (int i = 0; i < iterations; i++) {
                    System.out.println("From secondary thread: " + i);
                    sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            target.call(threadID);
        }

    }

}
