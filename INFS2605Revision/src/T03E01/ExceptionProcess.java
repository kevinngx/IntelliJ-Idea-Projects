package T03E01;


public class ExceptionProcess {
    public static void main(String[] args) {
        try {
            doStuff();
        } catch (Exception e){

        } finally {
            System.out.println("Is this still running...?");
        }
        System.out.println("Still running");
    }

    private static void doStuff() throws Exception  {


        throw new Exception("hello");


    }
}
