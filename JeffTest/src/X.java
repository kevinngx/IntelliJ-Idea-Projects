public class X {
    private static int value = 10;
    public static class Y {
        public void showIt() {
            System.out.println("Value: " + value);
            System.out.println("Value: " + getValue());
            System.out.println("Value: " + X.getValue());
        }
    }
    public static int getValue() {
        return  value;
    }
    public static void main(String[] args) {
        Y y = new Y();
        y.showIt();

    }
}
