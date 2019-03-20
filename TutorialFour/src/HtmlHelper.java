import java.io.*;

public class HtmlHelper {
    /**
     *  The method writes the content to a particular file
     * @param filename either "file1.txt" or "file2.txt"
     * @param content parse in "Hello World"
     */
    public static void replaceFileContents(String filename, String content) {
        try {
            FileOutputStream writer = new FileOutputStream(filename);
            writer.write((content).getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String htmlHeadTag() {
        String preparedReturn = "<head>";
        preparedReturn += "<title>My Pets</title>";
        preparedReturn += "<style>";
        preparedReturn += "body { font-family: 'Allerta', sans-serif; }";
        preparedReturn += "td, th { background-color: #D6DBDF; padding: 0.5rem; }";
        preparedReturn += "th { text-align: left; }";
        preparedReturn += "</style>";
        preparedReturn += "</head>";

        return preparedReturn;
    }

    public static String htmlPetsTableHeader(String[] headerStrings) {
        String preparedReturn = "<tr>";
        for (int i = 0; i < headerStrings.length; i++) {
            preparedReturn += "<th>";
            preparedReturn += headerStrings[i];
            preparedReturn += "</th>";
        }

        preparedReturn += "</tr>";
        return preparedReturn;
    }
}