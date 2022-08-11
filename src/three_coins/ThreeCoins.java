package three_coins;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class ThreeCoins {
    @Test
    public void main() {
        In.open("src/three_coins/public/sample.in");
        Out.compareTo("src/three_coins/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
