package toppling_dominoes;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class TopplingDominoes {
    @Test
    public void main() {
        In.open("src/toppling_dominoes/public/sample.in");
        Out.compareTo("src/toppling_dominoes/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
