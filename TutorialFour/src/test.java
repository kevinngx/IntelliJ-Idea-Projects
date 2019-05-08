import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) throws ParseException {

        int day = 20;
        int month = 6;
        int year = 1997;

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(day));
        sb.append("/");
        sb.append(Integer.toString(month));
        sb.append("/");
        sb.append(Integer.toString(year));

        String dateString = sb.toString();
        System.out.println(dateString);

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        System.out.printf("Date = %s \nmonth = %s\nyear = %s\n", date.getDate(), date.getMonth(), date.getYear());
        System.out.println(date.toString());

    }

}
