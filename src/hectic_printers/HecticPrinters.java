package hectic_printers;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HecticPrinters {
    @Test
    public void main() {
        In.open("src/hectic_printers/public/test1.in");
        Out.compareTo("src/hectic_printers/public/test1.out");

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

        if (m == 0) {
            Out.println(0D);
            return;
        }

        // dp[i][j] = expected number of pages printed if we start
        // from i and have j minutes left
        double[][] dp = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = p[i];
        }

        for (int j = 2; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                double last = i + 1 < n ? dp[i + 1][j - 1] : 0;
                dp[i][j] = p[i] * (1 + last) + (1 - p[i]) * dp[i][j - 1];
            }
        }

        Out.println(dp[0][m]);
    }
}
