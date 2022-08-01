package island;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Island {
    @Test
    public void main() {
        In.open("src/island/public/sample.in");
        Out.compareTo("src/island/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
