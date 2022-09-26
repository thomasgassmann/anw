package hourglass;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Hourglass {
    @Test
    public void main() {
        In.open("src/hourglass/public/test1.in");
        Out.compareTo("src/hourglass/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private void testCase() {

    }
}
