package sum_of_the_dice;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class SumOfTheDice {
    @Test
    public void main() {
        In.open("src/sum_of_the_dice/public/sample.in");
        Out.compareTo("src/sum_of_the_dice/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
