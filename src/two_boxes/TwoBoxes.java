package two_boxes;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TwoBoxes {
    @Test
    public void main() {
        In.open("src/two_boxes/public/test3.in");
        Out.compareTo("src/two_boxes/public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static double allBlue(int blue, int red, int n) {
        double p = 1;
        for (int i = 0; i < n; i++) {
            p *= (blue - i) / (double)(red + blue - i);
        }

        return p;
    }

    private static double q1(int r1, int b1, int r2, int b2) {
        return
                r1 / (double)(r1 + b1) * (r2 + 1) / (r2 + 1.0 + b2)
              + b1 / (double)(r1 + b1) * r2 / (r2 + 1.0 + b2);
    }

    private static double q2(int r1, int b1, int r2, int b2) {
        // Pr[red ball from A to B | red ball drawn from B] =
        // Pr[red ball drawn from B and red ball from A to B] / Pr[red ball drawn from B]
        double p = r1 / (double)(r1 + b1) * (r2 + 1) / (r2 + 1.0 + b2);
        return p / q1(r1, b1, r2, b2);
    }

    private static double q3(int r1, int b1, int r2, int b2, int n) {
        // Pr[at least one ball from B red | red ball from A to B] =
        // 1 - Pr[all balls from B blue | red ball from A to B]
        // 1 - Pr[red ball from A to B and all balls from B blue] / Pr[red ball from A to b]
        return 1 - allBlue(b2, r2 + 1, n);
    }

    private static void testCase() {
        int r1 = In.readInt();
        int b1 = In.readInt();
        int r2 = In.readInt();
        int b2 = In.readInt();

        int n = In.readInt();
        int x = In.readInt();

        var d = new DecimalFormat("#.#####");
        d.setMinimumFractionDigits(1);
        switch (x) {
            case 1:
                Out.println(d.format(q1(r1, b1, r2, b2)));
                break;
            case 2:
                Out.println(d.format(q2(r1, b1, r2, b2)));
                break;
            case 3:
                Out.println(d.format(q3(r1, b1, r2, b2, n)));
                break;
            default:
                break;
        }
    }
}
