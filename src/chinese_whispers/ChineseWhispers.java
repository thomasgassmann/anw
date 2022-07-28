package chinese_whispers;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ChineseWhispers {
    @Test
    public void main() {
        In.open("src/chinese_whispers/public/test3.in");
        Out.compareTo("src/chinese_whispers/public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = In.readDouble();
        }

        DecimalFormat df = new DecimalFormat("#.####");
        df.setMinimumFractionDigits(1);
        df.setRoundingMode(RoundingMode.FLOOR);
        Out.println(df.format(solve(n, m, p)));
    }

    private static double solve(int n, int m, double[] p) {
        // dp[i][j]: probability that we have value j at i-th step
        double[][] dp = new double[n + 1][2];
        dp[0][m] = 1;
        dp[0][1 - m] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - p[i - 1]) + dp[i - 1][1] * p[i - 1];
            dp[i][1] = dp[i - 1][1] * (1 - p[i - 1]) + dp[i - 1][0] * p[i - 1];
        }

        return dp[n][m];
    }
}
