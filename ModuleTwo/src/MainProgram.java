public class MainProgram {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long maxLengthTime = 1000 * 600; // 600 seconds == 10 minutes

        Thread threadOne = new Thread(new AstroDroid("R2-D2"));
        Thread threadTwo = new Thread(new AstroDroid("BB-08"));
        Thread threadRecord = new Thread(new Recorder());

        threadOne.start();
        threadTwo.start();
        threadRecord.start();

        // If either is still running past 10 mins, we stop
        while (threadOne.isAlive() || threadTwo.isAlive()) { // while either threads are still active; do the following
            if ( (System.currentTimeMillis() - startTime) > maxLengthTime ) { // has it been 10 minutes yet?
                if (threadOne.isAlive()) {
                    threadOne.interrupt(); // interrupt() - "hey pack up your stuff"
                    threadOne.join(); // join() "I will wait for you to clean up your stuff"
                } else if (threadTwo.isAlive()) {
                    threadTwo.interrupt();
                    threadTwo.join();
                }
            }

        }
        // The program waits until both threads are properly cleaned up
        threadRecord.interrupt();
        threadRecord.join();
    }

}
