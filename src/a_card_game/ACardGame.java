package a_card_game;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class ACardGame {
    @Test
    public void main() {
        In.open("src/a_card_game/public/test2.in");
        Out.compareTo("src/a_card_game/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();

        // Binomial coefficient
        // Algorithms.binom(n, k) returns 'n choose k'

        // Factorial
        // Algorithms.fact(n) returns 'n!'

        // Output using Out.java class
        Out.println(n + n);
    }
}
