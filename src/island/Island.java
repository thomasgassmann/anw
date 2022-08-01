package island;

import algorithms.Algorithms;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

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

    private static HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, Double>>>> memo = new HashMap<>();

    private static void setmemo(int b, int h, int n, int survive, double prob) {
        if (!memo.containsKey(b)) {
            memo.put(b, new HashMap<>());
        }

        if (!memo.get(b).containsKey(h)) {
            memo.get(b).put(h, new HashMap<>());
        }

        if (!memo.get(b).get(h).containsKey(n)) {
            memo.get(b).get(h).put(n, new HashMap<>());
        }

        memo.get(b).get(h).get(n).put(survive, prob);
    }

    private static Double getmemo(int b, int h, int n, int survive) {
        if (!memo.containsKey(b) || !memo.get(b).containsKey(h) ||
            !memo.get(b).get(h).containsKey(n) || !memo.get(b).get(h).get(n).containsKey(survive)) {
            return null;
        }

        return memo.get(b).get(h).get(n).get(survive);
    }

    private static double survive(int b, int h, int n, int survive) {
        if (b == 0 && n == 0) {
            return survive == 1 ? 1 : 0;
        }

        if (b == 0 && h == 0) {
            return survive == 2 ? 1 : 0;
        }

        if (n == 0 && h == 0) {
            return survive == 0 ? 1 : 0;
        }

        Double m = getmemo(b, h, n, survive);
        if (m != null) {
            return m;
        }

        double total = 0;
        double choose = Algorithms.binom(b + n + h, 2);
        double bearHunter = b * h / choose;
        double bearNinja = b * n / choose;
        double ninjaHunter = n * h / choose;
        if (b > 0 && h > 0) {
            total += bearHunter * survive(b - 1, h, n, survive); // bear and hunter, bear dies
        }

        if (n > 0 && b > 0) {
            total += bearNinja * survive(b, h, n - 1, survive); // bear and ninja, ninja dies
        }

        if (h > 0 && n > 0) {
            total += ninjaHunter * survive(b, h - 1, n, survive); // ninja and hunter, hunter dies
        }

        total /= (bearNinja + bearHunter + ninjaHunter);

        setmemo(b, h, n, survive, total);

        return total;
    }

    private static void testCase() {
        int b = In.readInt();
        int h = In.readInt();
        int n = In.readInt();

        double bear = survive(b, h, n, 0);
        double hunter = survive(b, h, n, 1);
        double ninja = 1 - bear - hunter;

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
