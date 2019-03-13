import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 __   _    _  _  _ ___   ___  __  _  ___   ___  _ _  _  __    __  _     _   __  __ 
|  \ / \  | \| |/ \_ _| | __||  \| ||_ _| |_ _|| U || |/ _|  / _|| |   / \ / _|/ _|
| o | o ) | \\ ( o ) |  | _| | o ) | | |   | | |   || |\_ \ ( (_ | |_ | o |\_ \\_ \
|__/ \_/  |_|\_|\_/|_|  |___||__/|_| |_|   |_| |_n_||_||__/  \__||___||_n_||__/|__/
*/

/**
 * DO NOT edit any of the methods here, these methods are here to help you out.
 * Please read about what method does
 */

public class Helper {
    /**
     * This method counts the number of lines in a filename.
     * All you need to do is to call with the method and parse the parameter of the name of the file
     * @return the number of lines in the file
     */
    public static int countLines(String filename) {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    /**
     *  Timestamp returns the date and time currently right now in the format of: 02-03-2019 08:00:14
     *  You can then use that to print out the current date and time
     */
    public static String timeStamp(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        String timeNow = date.format(formatter);
        return timeNow;
    }

    /**
     *  The method writes the content to a particular file
     * @param filename either "file1.txt" or "file2.txt"
     * @param content parse in "Hello World"
     */
    public static void writeToFile(String filename, String content) {
        try(FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(content);
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }
}