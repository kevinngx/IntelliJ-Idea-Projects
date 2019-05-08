import java.util.Date;

public class date {

    public static void main(String[] args) {
        int birthday = 35754;
        Date date = new Date();
        date.setTime(0);
        System.out.println("initial " + date.toString());
        date.setDate(20);
        date.setMonth(10);
        date.setYear(1997);
        System.out.println("After " + date.toString());
        System.out.println(date.getTime());
        19972011
    }
}
