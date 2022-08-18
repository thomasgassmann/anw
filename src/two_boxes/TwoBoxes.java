package two_boxes;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TwoBoxes {
    @Test
    public void main() {
        In.open("src/two_boxes/public/sample.in");
        Out.compareTo("src/two_boxes/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static double q1(int r1, int b1, int r2, int b2) {
        return
                r1 / (double)(r1 + b1) * (r2 + 1) / (r2 + 1.0 + b2)
              + b1 / (double)(r1 + b1) * r2 / (r2 + 1.0 + b2);
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
                Out.println('2');
                break;
            case 3:
                Out.println('3');
                break;
            default:
                break;
        }
    }
}
