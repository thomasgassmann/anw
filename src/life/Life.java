package life;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Life {
    @Test
    public void main() {
        In.open("src/life/public/sample.in");
        Out.compareTo("src/life/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        
    }
}
