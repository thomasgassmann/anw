package paint;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Paint {
    @Test
    public void main() {
        In.open("src/paint/public/sample.in");
        Out.compareTo("src/paint/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
