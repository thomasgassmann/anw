package frog_feeding;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FrogFeeding {
    @Test
    public void main() {
        In.open("src/frog_feeding/public/test2.in");
        Out.compareTo("src/frog_feeding/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int k = In.readInt();
        int m = In.readInt();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = In.readInt();
        }

        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = In.readDouble();
        }

        // dp[i][j] = expected number of flies eaten when
        // starting a path of length j from pond i
        double[][] dp = new double[n][m + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = f[i];

        for (int j = 1; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = f[i]
                            + (i - 1 >= 0 ? p[i] * dp[i - 1][j - 1] : 0)
                            + (i + 1 < n ? (1 - p[i]) * dp[i + 1][j - 1] : 0);
            }
        }

        DecimalFormat df = new DecimalFormat("#.#######");
        df.setMinimumFractionDigits(1);
        Out.println(df.format(dp[k][m]));
    }
}
