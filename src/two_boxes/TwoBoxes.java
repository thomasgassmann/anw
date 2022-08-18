package two_boxes;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class TwoBoxes {
    @Test
    public void main() {
        In.open("src/two_boxes/public/sample.in");
        Out.compareTo("src/two_boxes/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        
    }
}
