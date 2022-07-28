package chinese_whispers;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class ChineseWhispers {
    @Test
    public void main() {
        In.open("src/chinese_whispers/public/sample.in");
        Out.compareTo("src/chinese_whispers/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
    }
}
