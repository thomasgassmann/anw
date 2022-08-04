package random_divisors;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class RandomDivisors {
    @Test
    public void main() {
        In.open("src/random_divisors/public/sample.in");
        Out.compareTo("src/random_divisors/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
