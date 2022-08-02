package ping_pong;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class PingPong {
    @Test
    public void main() {
        In.open("src/ping_pong/public/sample.in");
        Out.compareTo("src/ping_pong/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
