package buy_low_sell_high;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class BuyLowSellHigh {
    @Test
    public void main() {
        In.open("src/buy_low_sell_high/public/test1.in");
        Out.compareTo("src/buy_low_sell_high/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        var graph = new Graph(n);

        int MAX = 10000;
        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();
            int c = In.readInt(); // 1 wood, -1 brick
            graph.addEdge(u, v, c == 1 ? 1 : MAX);
            graph.addEdge(v, u, c == 1 ? 1 : MAX);
        }

        int f = graph.computeMaximumFlow(0, n - 1);
        if (f >= MAX) {
            Out.println("RICH");
        } else {
            Out.println(f / 2);
        }
    }
}
