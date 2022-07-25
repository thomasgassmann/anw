package slay_the_dragon;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class SlayTheDragon {
    @Test
    public void main() {
        In.open("src/slay_the_dragon/public/custom.in");
        Out.compareTo("src/slay_the_dragon/public/custom.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        // Input using In.java class
        int n = In.readInt();

        // Output using Out.java class
        Out.println(n + n);
    }
}
