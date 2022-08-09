package stop_thieves;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class StopThieves {
    @Test
    public void main() {
        In.open("src/stop_thieves/public/test1.in");
        Out.compareTo("src/stop_thieves/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        var graph = new Graph(n);

        final int MAX = 10000;
        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();
            int w = In.readInt();

            graph.addEdge(u, v, w >= 0 ? w : MAX);
        }

        var maxFlow = graph.computeMaximumFlow(0, n - 1);
        if (maxFlow >= MAX) {
            Out.println("no");
        } else {
            Out.println(maxFlow);
        }
    }
}
