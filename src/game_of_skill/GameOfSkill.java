package game_of_skill;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class GameOfSkill {
    @Test
    public void main() {
        In.open("src/game_of_skill/public/test3.in");
        Out.compareTo("src/game_of_skill/public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static double q1(int n, double[] p) {
        double res = 0;
        for (int i = 2; i <= 6; i += 2) {
            res += p[i - 1] * (1.0/6);
        }

        return res;
    }

    private static double q2(int n, double[] p) {
        // Pr[first throw 3 | second throw 7] =
        // Pr[first throw 3 and second throw 7] / Pr[second throw 7]
        double secondThrow7 = 0;
        for (int i = 1; i <= 6; i++) {
            int secondThrow = 7 - i;
            secondThrow7 += p[i - 1] * p[secondThrow - 1];
        }

        // first throw 3, then 4
        double numerator = p[2] * p[3];
        return numerator / secondThrow7;
    }

    private static double q3(int n, double[] p) {
        // expected number of throws to reach n
        double[] dp = new double[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                for (int j = i - 1; j >= i - 6 && j >= 0; j--) {
                    int minThrow = i - j;
                    double totalReach = 0;
                    for (int k = minThrow; k <= 6; k++) {
                        dp[i] += (1 + dp[j]) * p[k - 1];
                    }
                }

                continue;
            }

            for (int j = i - 1; j >= i - 6 && j >= 0; j--) {
                int throwValue = i - j;
                dp[i] += (1 + dp[j]) * p[throwValue - 1];
            }
        }

        return dp[n];
    }

    public static void testCase() {
        int n = In.readInt();
        int q = In.readInt();
        double[] p = new double[6];
        for (int i = 0; i < 6; i++) {
            p[i] = In.readDouble();
        }

        var df = new DecimalFormat("#.#######");
        switch (q) {
            case 1:
                Out.println(df.format(q1(n, p)));
                break;
            case 2:
                Out.println(df.format(q2(n, p)));
                break;
            case 3:
                Out.println(df.format(q3(n, p)));
                break;
            default:
                break;
        }
    }
}
