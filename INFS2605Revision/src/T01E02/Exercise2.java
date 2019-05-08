package T01E02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise2 {
    public static HashSet<String> pokemon;

    public static void main(String[] args) {
        pokemon = new HashSet<>();
        prompt();
        Scanner in = new Scanner(System.in);
        String pokemon = in.next();

        while (!pokemon.equals("LIST_ALL")) {
            addPokemon(pokemon);
            prompt();
            pokemon = in.next();
        }

        listAll();
    }

    public static void prompt() {
        System.out.print("Pokemon Sighted: ");
    }

    public static void addPokemon(String pokemon) {
        Exercise2.pokemon.add(pokemon);
    }

    public static void listAll() {
        // how can we generate an alphabetically sorted output from the set object?
        ArrayList<String> sortedPokemonList = new ArrayList<String>(Exercise2.pokemon);
        Collections.sort(sortedPokemonList);
        System.out.print("[");
        int i = 0;
        for (; i < sortedPokemonList.size() - 1; i++) {
            System.out.print(sortedPokemonList.get(i) + ", ");
        }
        System.out.println(sortedPokemonList.get(i) + "]");
    }
}
