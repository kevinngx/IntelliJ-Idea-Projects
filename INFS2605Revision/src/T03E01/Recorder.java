package T03E01;

/**
 * This class is responsible for counting the number of lines in the file1.txt and file2.txt
 * and then printing that out
 * Remember what you need to add in this class in order for it to be run in a thread
 */

public class Recorder implements Runnable{

    //Method called to count and print the number of lines in the text file
    public void printNoLines(){
        System.out.println(String.format("%s, File 1 has %s lines, File 2 has %s lines",
                Helper.timeStamp(), Helper.countLines("File1.txt"), Helper.countLines("File2.txt"))
        );
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