package rgb_marbles;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class RgbMarbles {
    @Test
    public void main() {
        In.open("src/rgb_marbles/public/sample.in");
        Out.compareTo("src/rgb_marbles/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
