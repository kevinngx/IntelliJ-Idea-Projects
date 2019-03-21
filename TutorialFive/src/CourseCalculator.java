import java.lang.NumberFormatException;
import java.nio.InvalidMarkException;
import java.util.Scanner;

public class CourseCalculator {

    public static void main(String[] args) {

        try {
            //Prompts and asks the user for the 3 assignment marks
            //Try to convert it to an integer in this block of code
            String input;

            int a = getMark(1);
            if (a == -1) throw new StopException();

            int b = getMark(2);
            if (b == -1) throw new StopException();

            int c = getMark(3);
            if (c == -1) throw new StopException();

            int required = 50 - (a + b + c);
            System.out.println("Percentage to pass the finals: " + required + "%");
        } catch (Exception e){
            //If it fails, it should be caught here
            e.printStackTrace();
        } catch (StopException e) {
            return;
        }

    }

    private static int getMark(int n) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Assignment " + n + " mark: ");
        String input = in.next();
        int intValue = 0;

        try {

            if (input.equals("stop")) {
                return -1;
            }

            //Throws a number format exception of the input is not a number
            intValue = Integer.parseInt(input);

            //Throws an invalid mark exception if the out of bounds
            if (!checkMark(intValue, n)) {
                throw new InvalidMarkException();
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a number and not characters");
            intValue = getMark(n);
        } catch (InvalidMarkException e) {
            System.out.println("You can't get less than 0 or marks more than the maximum mark!");
            intValue = getMark(n);
        }


        return intValue;
    }

    private static boolean checkMark(int intValue, int questionNumber) {
        boolean validMark = true;
        int maxMark = 15;
        if (questionNumber == 3) {
            maxMark = 20;
        }
        if (intValue < 0 || intValue > maxMark) {
            validMark = false;
        }
        return validMark;
    }


    private static class StopException extends Throwable {
        public StopException() {
            System.out.println("Exited!");
        }

    }
}
