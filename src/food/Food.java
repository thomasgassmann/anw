package food;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Food {
    @Test
    public void main() {
        In.open("src/food/public/sample.in");
        Out.compareTo("src/food/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
    }
}
