public class Recorder implements Runnable {



    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                printLatest();

            }
        } catch (InterruptedException e) {
            printLatest();
        }
    }

    public void printLatest() {
        String latestLine = TwoSixZeroFiveHelper.readFile("temp.txt");
        if (latestLine.length() > 0) {
            String timeStamp = TwoSixZeroFiveHelper.timeStamp();
            System.out.println("[" + timeStamp + "] " + latestLine);
        }
    }
}
