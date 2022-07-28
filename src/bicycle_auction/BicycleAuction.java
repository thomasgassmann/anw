package bicycle_auction;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

public class BicycleAuction {
    @Test
    public void main() {
        In.open("src/bicycle_auction/public/test1.in");
        Out.compareTo("src/bicycle_auction/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int c = In.readInt();
        int b = In.readInt();

        var graph = new Graph(c + b + 2);
        int SOURCE = c + b;
        int SINK = c + b + 1;

        for (int i = 0; i < c; i++) {
            int x = In.readInt();
            graph.addEdge(SOURCE, i, 1);

            for (int j = 0; j < x; j++) {
                int bicycle = In.readInt() - 1;
                graph.addEdge(i, c + bicycle, 1);
            }
        }

        for (int i = 0; i < b; i++) {
            graph.addEdge(c + i, SINK, 1);
        }

        Out.println(graph.computeMaximumFlow(SOURCE, SINK));
    }
}
