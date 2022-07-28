package frog_feeding;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class FrogFeeding {
    @Test
    public void main() {
        In.open("src/frog_feeding/public/sample.in");
        Out.compareTo("src/frog_feeding/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
