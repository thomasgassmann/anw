package christmas;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Christmas {
    @Test
    public void main() {
        In.open("src/christmas/public/sample.in");
        Out.compareTo("src/christmas/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {}
}
