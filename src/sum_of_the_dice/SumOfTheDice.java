package sum_of_the_dice;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SumOfTheDice {
    @Test
    public void main() {
        In.open("src/sum_of_the_dice/public/test1.in");
        Out.compareTo("src/sum_of_the_dice/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();
        int[] u = new int[n];
        int[] v = new int[m];
        for (int i = 0; i < n; i++) {
            u[i] = In.readInt();
        }

        for (int i = 0; i < m; i++) {
            v[i] = In.readInt();
        }

        int x = In.readInt();
        int y = In.readInt();
        int z = In.readInt();

        var format = new DecimalFormat("#.#######");
        format.setRoundingMode(RoundingMode.DOWN);
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(6);

        Out.print(format.format(q1(u, v)));
        Out.print(' ');
        Out.print(format.format(q2(u, v, x, y)));
        Out.print(' ');
        Out.println(format.format(q3(u, v, z)));
    }

    private static double q3(int[] n, int[] m, int z) {
        // E[N + M | N < z]
        double total = 0;
        int totalSmaller = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] < z) {
                totalSmaller++;
            }
        }

        double one = 1D / (totalSmaller * m.length);
        for (int i = 0; i < n.length; i++) {
            if (n[i] < z) {
                for (int j = 0; j < m.length; j++) {
                    total += one * (n[i] + m[j]);
                }
            }
        }

        return total;
    }

    private static double q2(int[] n, int[] m, int x, int y) {
        // N: first roll, M: second roll
        // Pr[N + M > x | N < y]
        double total = 0;
        int totalSmaller = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] < y) {
                totalSmaller++;
            }
        }

        double one = 1D / (totalSmaller * m.length);
        for (int i = 0; i < n.length; i++) {
            if (n[i] < y) {
                for (int j = 0; j < m.length; j++) {
                    if (n[i] + m[j] > x) {
                        total += one;
                    }
                }
            }
        }

        return total;
    }

    private static double q1(int[] n, int[] m) {
        int nsum = 0;
        int msum = 0;
        for (int i = 0; i < n.length; i++)
            nsum += n[i];
        for (int i = 0; i < m.length; i++)
            msum += m[i];
        return nsum / (double)n.length + msum / (double)m.length;
    }
}
