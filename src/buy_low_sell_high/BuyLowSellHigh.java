package buy_low_sell_high;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class BuyLowSellHigh {
    @Test
    public void main() {
        In.open("src/buy_low_sell_high/public/test3.in");
        Out.compareTo("src/buy_low_sell_high/public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {

    }
}
