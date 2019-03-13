import java.util.HashSet;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = "";
        HashSet<String> pokemonSet = new HashSet<String>();

        while (true) {
            System.out.println("Pokemon sighted: ");
            input = in.next();
            if (input.equals("LIST_ALL")) {
                break;
            }
            pokemonSet.add(input);
        }

        for (String pokemon : pokemonSet) {
            System.out.println(pokemon);
        }

    }

}
