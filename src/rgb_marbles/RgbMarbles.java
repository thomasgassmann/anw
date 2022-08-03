package rgb_marbles;

import algorithms.Algorithms;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RgbMarbles {
    @Test
    public void main() {
        In.open("src/rgb_marbles/public/test1.in");
        Out.compareTo("src/rgb_marbles/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int r = In.readInt();
        int g = In.readInt();
        int b = In.readInt();
        int total = r + b + g;

        int m = In.readInt();

        int x = In.readInt();
        int y = In.readInt();
        int z = In.readInt();

        // (x choose r) * (y choose g) * (z choose b) / (total choose m)
        long numerator = Algorithms.binom(r, x) * Algorithms.binom(g, y) * Algorithms.binom(b, z);
        long denominator = Algorithms.binom(total, m);

        double prob = numerator / (double)denominator;
        DecimalFormat df = new DecimalFormat("#.########");
        df.setMinimumFractionDigits(1);
        df.setRoundingMode(RoundingMode.FLOOR);
        Out.println(df.format(prob));
    }
}
