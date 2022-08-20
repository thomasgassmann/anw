package toppling_dominoes;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class TopplingDominoes {
    @Test
    public void main() {
        In.open("src/toppling_dominoes/public/test2.in");
        Out.compareTo("src/toppling_dominoes/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int fallUntil = In.readInt();
        for (int i = 1; i < n; i++) {
            int h = In.readInt();
            if (i < fallUntil) {
                fallUntil = Math.min(Math.max(fallUntil, i + h), n);
            }
        }

        Out.println(fallUntil);
    }
}
