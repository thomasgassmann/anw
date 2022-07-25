package slay_the_dragon;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.HashMap;

public class SlayTheDragon {
    @Test
    public void main() {
        In.open("src/slay_the_dragon/public/test2.in");
        Out.compareTo("src/slay_the_dragon/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        memo = new HashMap<>();

        int n = In.readInt(); // health points dragon
        int f = In.readInt(); // frost power
        int s = In.readInt(); // shadow power
        int x = In.readInt(); // hp dragon decrease on frost bolt
        int y = In.readInt(); // hp dragon decrease on shadow bolt

        double res = expectedValue(n, f, s, x, y);
        if (Double.isNaN(res)) {
            Out.println(-1);
        } else {
            DecimalFormat df = new DecimalFormat("#.#######");
            df.setMinimumFractionDigits(1);
            Out.println(df.format(res));
        }
    }

    private static HashMap<Integer, HashMap<Integer, HashMap<Integer, Double>>> memo = new HashMap<>();

    private static boolean has(int n, int f, int s) {
        return memo.containsKey(n) && memo.get(n).containsKey(f) && memo.get(n).get(f).containsKey(s);
    }

    private static double get(int n, int f, int s) {
        return memo.get(n).get(f).get(s);
    }

    private static void memoize(int n, int f, int s, double value) {
        if (!memo.containsKey(n)) {
            memo.put(n, new HashMap<>());
        }

        if (!memo.get(n).containsKey(f)) {
            memo.get(n).put(f, new HashMap<>());
        }

        memo.get(n).get(f).put(s, value);
    }

    private static double expectedValue(int n, int f, int s, int x, int y) {
        if (f * x + s * y < n) {
            return Double.NaN;
        }

        if (n <= 0) {
            return 0;
        }

        if (n <= x && n <= y) {
            return 1;
        }

        if (has(n, f, s)) {
            return get(n, f, s);
        }

        double frost = ((double)f / (f + s));
        double shadow = ((double)s / (f + s));
        double total = 0;
        if (frost > 0) {
            total += frost * (1 + expectedValue(n - x, f - 1, s, x, y));
        }

        if (shadow > 0) {
            total += shadow * (1 + expectedValue(n - y, f, s - 1, x, y));
        }

        double res = total == 0 ? Double.NaN : total;
        memoize(n, f, s, res);
        return res;
    }
}
