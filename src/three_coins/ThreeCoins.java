package three_coins;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class ThreeCoins {
    @Test
    public void main() {
        In.open("src/three_coins/public/sample.in");
        Out.compareTo("src/three_coins/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt(); // number of times experiment is repeated
        int x = In.readInt(); // question, 1, 2, 3. if x in {1, 2} then n = 1

        double p = In.readDouble(); // probability of master coin showing alpha
        double a = In.readDouble(); // alpha coin shows red
        double b = In.readDouble(); // beta coin shows red

        var df = new DecimalFormat("#.#####");
        df.setMinimumFractionDigits(1);
        switch (x) {
            case 1:
                Out.println(df.format(q1(p, a, b)));
                break;
            case 2:
                Out.println(df.format(q2(p, a, b)));
                break;
            case 3:
                Out.println(df.format(q3(n, p, a, b)));
                break;
            default:
                break;
        }
    }

    private static double q3(int n, double p, double a, double b) {
        return 0;
    }

    private static double q2(double p, double a, double b) {
        // Pr[alpha coin tossed | we see red] = Pr[alpha coin tossed and red] / Pr[we see red]
        return p * a / q1(p, a, b);
    }

    private static double q1(double p, double a, double b) {
        return p * a + (1 - p) * b;
    }
}
