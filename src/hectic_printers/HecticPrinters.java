package hectic_printers;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HecticPrinters {
    @Test
    public void main() {
        In.open("src/hectic_printers/public/test2.in");
        Out.compareTo("src/hectic_printers/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static HashMap<Integer, HashMap<Integer, Double>> memo;

    private static Double getmemo(int s, int m) {
        if (!memo.containsKey(s) || !memo.get(s).containsKey(m)) {
            return null;
        }

        return memo.get(s).get(m);
    }

    private static void memoize(int s, int m, double res) {
        if (!memo.containsKey(s)) {
            memo.put(s, new HashMap<>());
        }

        memo.get(s).put(m, res);
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = In.readDouble();
        }

        memo = new HashMap<>();
        double res = expected(p, 0, m);
        Out.println(res);
    }

    private static double expected(double[] p, int start, int minutesLeft) {
        if (start >= p.length || minutesLeft == 0) {
            return 0;
        }

        if (minutesLeft == 1) {
            return p[start];
        }

        Double c = getmemo(start, minutesLeft);
        if (c != null) {
            return c;
        }

        double res = p[start] * (1 + expected(p, start + 1, minutesLeft - 1)) +
                (1 - p[start]) * expected(p, start, minutesLeft - 1);
        memoize(start, minutesLeft, res);
        return res;
    }
}
