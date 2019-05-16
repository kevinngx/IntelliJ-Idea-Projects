public class ExceptionTest {

    public static void main(String args[]){
        try{
            throw new NullPointerException();
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException caught!");
        }
        catch(Exception e){
            System.out.println("Exception caught!");
        }
        catch(Throwable e){
            System.out.println("Throwable caught!");
        }
    }

}
