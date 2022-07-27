package a_card_game;

import algorithms.Algorithms;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ACardGame {
    @Test
    public void main() {
        In.open("src/a_card_game/public/test1.in");
        Out.compareTo("src/a_card_game/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    public static void testCase() {
        int n = In.readInt(); // number of cards
        int m = In.readInt(); // cards we pick

        DecimalFormat df = new DecimalFormat("#.########");
        df.setMinimumFractionDigits(1);
        df.setRoundingMode(RoundingMode.FLOOR);
        Out.println(df.format(prob(n, m)));
    }

    private static double prob(int n, int m) {
        /*
            But you could write
                ((n-m)*(n-m-1) + (n-m)*2 + (n-m+1)) / (n choose m)
            the first term being all the (m-1) consecutive cards in the middle which can
            have any of the remaining cards not adjacent to them (of which there are n-m-1);
            the next term are the two (m-1) consecutive cards at the edge which can have any
            of the remaining cards not adjacent to them (n-m) in their group and finally there
            are (n-m+1) m-consecutive card groups
         */
        return (double)((n - (m - 2)) * (n - (m - 1)) - (n - (m - 1)))  / Algorithms.binom(n, m);
    }
}
