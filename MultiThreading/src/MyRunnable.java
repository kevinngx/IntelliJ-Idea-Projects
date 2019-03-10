public class MyRunnable implements Runnable {

    @Override
    public void run() {
        int iterations = 5;

        try {
            for (int i = 0; i < iterations; i++) {
                System.out.println("From Runnable: " + i);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

}
