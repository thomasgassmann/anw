package life;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class Life {
    @Test
    public void main() {
        In.open("src/life/public/test1.in");
        Out.compareTo("src/life/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        var graph = new Graph(2 * n + 2);
        int SOURCE = 2 * n;
        int SINK = 2 * n + 1;
        int MAX = 10000;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int p = In.readInt();
            int f = In.readInt();

            graph.addEdge(i, i + n, MAX);

            graph.addEdge(SOURCE, i, p);
            graph.addEdge(i + n, SINK, f);

            total += f;
        }

        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();

            graph.addEdge(u, v + n, MAX);
        }

        var max = graph.computeMaximumFlow(SOURCE, SINK);
        Out.println(max == total ? "yes" : "no");
    }
}
