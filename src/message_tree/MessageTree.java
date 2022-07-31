package message_tree;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class MessageTree {
    @Test
    public void main() {
        In.open("src/message_tree/public/sample.in");
        Out.compareTo("src/message_tree/public/sample.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        
    }
}
