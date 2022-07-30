package jackpot;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Jackpot {
    @Test
    public void main() {
        In.open("src/jackpot/public/sample.in");
        Out.compareTo("src/jackpot/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
