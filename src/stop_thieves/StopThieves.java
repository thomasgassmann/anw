package stop_thieves;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class StopThieves {
    @Test
    public void main() {
        In.open("src/stop_thieves/public/sample.in");
        Out.compareTo("src/stop_thieves/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        
    }
}
