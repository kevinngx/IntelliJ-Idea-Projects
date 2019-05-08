public class AbstractMain {
    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            void sayBye() {
                System.out.println("Bye");
            }
        };

        abstractClass.sayHello();
        abstractClass.sayBye();

        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            void sayBye() {
                System.out.println("Bye Nigga");
            }
        };

        abstractClass1.sayHello();
        abstractClass1.sayBye();

        

        

    }
}
