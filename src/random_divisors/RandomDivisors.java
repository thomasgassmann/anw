package random_divisors;

import algorithms.Algorithms;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;

public class RandomDivisors {
    @Test
    public void main() {
        In.open("src/random_divisors/public/test2.in");
        Out.compareTo("src/random_divisors/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static long gcd(long a, long b) {
        if (b > a) {
            return gcd(b, a);
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        if (b > a) {
            return lcm(b, a);
        }

        return (a / gcd(a, b)) * b;
    }

    private static long lcm(long[] values, long max) {
        if (values.length == 1) {
            return values[0];
        }

        long l = lcm(values[0], values[1]);
        if (l > max) {
            return -1;
        }

        for (int i = 2; i < values.length; i++) {
            l = lcm(l, values[i]);
            if (l > max) {
                return -1;
            }
        }

        return l;
    }

    private static long ofLength(long[] values, long max, int length, int start, HashSet<Long> current) {
        if (current.size() == length) {
            long l = lcm(current.stream().mapToLong(p -> p).toArray(), max);
            if (l < 0) {
                return 0;
            }

            return max / l;
        }

        if (start == values.length) {
            return 0;
        }

        long total = 0;
        long c = values[start];
        current.add(c);
        total += ofLength(values, max, length, start + 1, current);
        current.remove(c);
        total += ofLength(values, max, length, start + 1, current);

        return total;
    }

    private static long numbersDivisibleBy(long[] values, long max) {
        long total = 0;
        for (int l = 1; l <= values.length; l++) {
            long inc = l % 2 == 1 ? 1 : -1;

            long num = ofLength(values, max, l, 0, new HashSet<Long>());

            total += inc * num;
        }

        return total;
    }

    private static void testCase() {
        int k = In.readInt();

        long[] a = new long[k];
        for (int i = 0; i < k; i++) {
            a[i] = In.readInt();
        }

        a = Arrays.stream(a).distinct().toArray();

        long max = (long)Math.pow(10, 10);
        long numbersDivisibleBy = numbersDivisibleBy(a, max);
        long options = max - numbersDivisibleBy;

        DecimalFormat df = new DecimalFormat("#.######");
        df.setMinimumFractionDigits(1);
        df.setRoundingMode(RoundingMode.FLOOR);
        Out.println(df.format(options / (double)max));
    }
}
