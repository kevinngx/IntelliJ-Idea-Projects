import java.util.Scanner;

public class Divider {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            //Normal execution is here - prompts user for input
            System.out.printf("Enter the number you are dividing: ");
            int a = scanner.nextInt();
            System.out.printf("Enter the number you are dividing by: ");
            int b = scanner.nextInt();
            System.out.println("Result: " + (a / b));
        }catch (Exception e){
            // Exception is caught if it is dividing by 0
            System.out.println("You can't divide by 0!");
        }
        finally {
            System.out.println("Divider program has terminated");
        }
    }
}
