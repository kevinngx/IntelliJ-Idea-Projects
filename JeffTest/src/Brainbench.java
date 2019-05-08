public class Brainbench<B> {
    B b;

    public <B> void printMe (B b) {
        System.out.println(b.getClass().getName());
    }
    public static void main (String[] args) {
        Brainbench<Brainbench> b =
                new Brainbench<Brainbench>();
        b.printMe("Hello, World");
    }
}
