package island;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class Island {
    @Test
    public void main() {
        In.open("src/island/public/test1.in");
        Out.compareTo("src/island/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static double[][][] surviveBear(int b, int h, int n) {
        // dp[i][j][k]: probability of bear winning if i bears, j hunters, k ninjas remaining
        // 0 <= i <= b
        // 0 <= j <= h
        // 0 <= k <= n
        int size = Math.max(b, Math.max(h, n)) + 1;
        double[][][] dp = new double[size][size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (i == 0 || j == 0 && k == 0) {
                        dp[i][j][k] = i == 0 ? 0 : 1;
                        continue;
                    }

                    double choose = 1.0 / (i * j + j * k + i * k);
                    double bearHunter = i * j * choose;
                    double bearNinja = i * k * choose;
                    double ninjaHunter = j * k * choose;

                    dp[i][j][k] = bearHunter * dp[i - 1][j][k]
                            + bearNinja * (k - 1 >= 0 ? dp[i][j][k - 1] : 0)
                            + ninjaHunter * (j - 1 >= 0 ? dp[i][j - 1][k] : 0);
                }
            }
        }

        return dp;
    }

    private static void testCase() {
        int b = In.readInt();
        int h = In.readInt();
        int n = In.readInt();

        double[][][] dp = surviveBear(b, h, n);
        double bear = dp[b][h][n];
        double hunter = dp[h][n][b];
        double ninja = dp[n][b][h];

        DecimalFormat df = new DecimalFormat("#.######");
        df.setMinimumFractionDigits(1);

        Out.print(df.format(bear));
        Out.print(' ');
        Out.print(df.format(hunter));
        Out.print(' ');
        Out.print(df.format(ninja));
        Out.println();
    }
}
