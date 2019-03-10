/**
 * This class is responsible for counting the number of lines in the file1.txt and file2.txt
 * and then printing that out
 * Remember what you need to add in this class in order for it to be run in a thread
 */
public class Recorder implements Runnable {

    //Method called to count and print the number of lines in the text file
    public void printNoLines(){

        StringBuilder sb = new StringBuilder();
        sb.append(Helper.timeStamp());
        sb.append(", File 1 has ");
        sb.append(Helper.countLines("file1.txt"));
        sb.append(" lines, File 2 has ");
        sb.append(Helper.countLines("file2.txt"));
        sb.append(" lines");
        System.out.println(sb.toString());

    }

    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(500);
                printNoLines();
            }
        } catch (InterruptedException e) {
            System.out.println("Recorder Thread Interrupted");
        }

    }
}