public class Recorder implements Runnable {

    public void printNoLines() {
        StringBuilder sb = new StringBuilder();
        sb.append(Helper.timeStamp());
        sb.append("File 1 has " + Helper.countLines("file1.txt") + " lines,");
        sb.append("File 2 has " + Helper.countLines("file2.txt") + " lines");
        System.out.println(sb.toString());
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                printNoLines();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
    }

}
