package food;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Food {
    @Test
    public void main() {
        In.open("src/food/public/test1.in");
        Out.compareTo("src/food/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        var graph = new Graph(2 + n + m);
        int SOURCE = n + m;
        int SINK = n + m + 1;

        int total = 0;
        for (int i = 0; i < n; i++) {
            int d = In.readInt();
            total += d;
            graph.addEdge(SOURCE, i, d);
        }

        for (int i = 0; i < m; i++) {
            int k = In.readInt();
            for (int j = 0; j < k; j++) {
                int f = In.readInt();
                graph.addEdge(f, n + i, 1);
            }

            graph.addEdge(n + i, SINK, 1);
        }

        var max = graph.computeMaximumFlow(SOURCE, SINK);
        Out.println(max == m ? "yes" : "no");
    }
}
