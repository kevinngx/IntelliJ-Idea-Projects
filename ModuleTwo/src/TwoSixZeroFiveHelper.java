import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TwoSixZeroFiveHelper {
    public static String timeStamp() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String timeNow = date.format(formatter);
        return timeNow;
    }

    public static void replaceFileContents(String filename, String content) {
        try {
            FileOutputStream writer = new FileOutputStream(filename);
            writer.write((content).getBytes());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
