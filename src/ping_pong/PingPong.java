package ping_pong;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PingPong {
    @Test
    public void main() {
        In.open("src/ping_pong/public/test2.in");
        Out.compareTo("src/ping_pong/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int g = In.readInt();
        int s = In.readInt();
        double p = In.readDouble();

        // dp[i][j] = probability of winning the game if we have i gold and j silver bowls
        double[][] dp = new double[g + 1][s + 1];
        dp[1][0] = 1;

        for (int i = 0; i <= g; i++) {
            for (int j = 0; j <= s; j++) {
                if (i + j <= 1) {
                    continue;
                }

                double goldOnly = i / (double)(i + j) * (i - 1) / (i + j - 1);
                double silverOnly = j / (double)(i + j) * (j - 1) / (i + j - 1);
                double goldAndSilver = 1 - goldOnly - silverOnly;

                double prevI = (i - 1 >= 0 ? dp[i - 1][j] : 0);
                double prevJ = (j - 1 >= 0 ? dp[i][j - 1] : 0);
                dp[i][j] = goldOnly * prevI
                        + silverOnly * prevJ
                        + p * goldAndSilver * prevI
                        + (1 - p) * goldAndSilver * prevJ;
            }
        }

        DecimalFormat df = new DecimalFormat("#.#####");
        df.setMinimumFractionDigits(1);
        Out.println(df.format(dp[g][s]));
    }
}
