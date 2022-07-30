package jackpot;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Jackpot {
    @Test
    public void main() {
        In.open("src/jackpot/public/test2.in");
        Out.compareTo("src/jackpot/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int k = In.readInt();

        int[][] values = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                values[i][j] = In.readInt();
            }

            Arrays.sort(values[i]);
        }

        // dp[][] = probability of increasing sequence of length j
        // when starting from i
//        double res = prob(n, k, values, 0, -1);
        double res = jackpot(n, k, values);
        DecimalFormat df = new DecimalFormat("#.######");
        df.setMinimumFractionDigits(1);
        Out.println(df.format(res));
    }

    private static double jackpot(int n, int k, int[][] values) {
        // dp[i][j] = probability of increasing sequence when starting at i and
        // having chosen value at index j
        double[][] dp = new double[n][k];
        for (int i = 0; i < k; i++) {
            dp[n - 1][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = 0;
                for (int l = 0; l < k; l++) {
                    if (values[i + 1][l] >= values[i][j]) {
                        dp[i][j] += 1 / (double)k * dp[i + 1][l];
                    }
                }
            }
        }

        double total = 0;
        for (int i = 0; i < k; i++) {
            total += 1 / (double)k * dp[0][i];
        }

        return total;
    }

    private static double prob(int n, int k, int[][] values, int wheel, int value) {
        if (wheel >= n) {
            return 1;
        }

        int[] possible = values[wheel];
        double total = 0.0;
        for (int i = 0; i < k; i++) {
            if (possible[i] >= value) {
                total += 1.0 / k * prob(n, k, values, wheel + 1, possible[i]);
            }
        }

        return total;
    }
}
