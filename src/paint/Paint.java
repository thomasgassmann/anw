package paint;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Paint {
    @Test
    public void main() {
        In.open("src/paint/public/test3.in");
        Out.compareTo("src/paint/public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static double q1(int b, int w) {
        double total = b + w;
        return w / total * (b + 1) / total + Math.pow(b / total, 2);
    }

    private static double q2(int b, int w) {
        // Pr[brother painted white stone black | we've chosen black] =
        // Pr[brother paints white stone black and we choose black] / Pr[we choose black]
        double total = b + w;
        double numerator = w / total * (b + 1) / total;
        double denominator = numerator + Math.pow(b / total, 2);

        return numerator / denominator;
    }

    private static HashMap<Integer, HashMap<Integer, Double>> memo;

    private static void setmemo(int w, int steps, double res) {
        if (!memo.containsKey(w)) {
            memo.put(w, new HashMap<Integer, Double>());
        }

        memo.get(w).put(steps, res);
    }

    private static Double getmemo(int w, int steps) {
        if (!memo.containsKey(w)) {
            return null;
        }

        return memo.get(w).getOrDefault(steps, null);
    }

    private static double q3rec(int b, int w, int step) {
        if (step == 0 || w == 0) {
            return w == 0 ? 1 : 0;
        }

        Double m = getmemo(w, step);
        if (m != null) {
            return m;
        }

        double total = b + w;
        double res = b / total * q3rec(b, w, step - 1) + w / total * q3rec(b + 1, w - 1, step - 1);
        setmemo(w, step, res);
        return res;
    }

    private static double q3(int b, int w) {
        // dp[i][j] probability that after i steps b + j stones are now black
        double[][] dp = new double[w + 2][w + 1];
        double total = b + w;
        dp[0][0] = 1;
        for (int j = 1; j < w + 2; j++) {
            dp[j][0] = dp[j - 1][0] * (b / total);
        }

        for (int i = 1; i < w + 2; i++) {
            for (int j = 1; j < w + 1; j++) {
                dp[i][j] = dp[i - 1][j] * (b + j) / total // choose black
                         + dp[i - 1][j - 1] * (w - (j - 1)) / total; // choose white
            }
        }

        return dp[w + 1][w];
    }

    private static void testCase() {
        int b = In.readInt();
        int w = In.readInt();
        int x = In.readInt();

        DecimalFormat df = new DecimalFormat("#.########");
        df.setMinimumFractionDigits(1);
        switch (x) {
            case 1:
                Out.println(df.format(q1(b, w)));
                break;
            case 2:
                Out.println(df.format(q2(b, w)));
                break;
            case 3:
                memo = new HashMap<>();
                Out.println(df.format(q3(b, w)));
                break;
            default:
                break;
        }
    }
}
