package T03E01;

public class GrandChild extends Child {

    public GrandChild() {
        System.out.println("Printing GrandChild");
    }

    public void saySomething() {
        super.saySomething();
        System.out.println("FUCK JONSON");
    }

}
