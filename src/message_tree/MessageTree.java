package message_tree;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MessageTree {
    @Test
    public void main() {
        In.open("src/message_tree/public/test3.in");
        Out.compareTo("src/message_tree/public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() {
        int n = In.readInt();
        var edges = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        int[] inCost = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int u = In.readInt();
            int v = In.readInt();
            int c = In.readInt();
            edges[u].add(v);
            inCost[v] = c;
        }

        var max = longestPath(edges, inCost, 0);
        Out.println(max);
    }

    private static int longestPath(ArrayList<Integer>[] edges, int[] inCost, int vertex) {
        int max = 0;
        for (var v : edges[vertex]) {
            var current = inCost[v] + longestPath(edges, inCost, v);
            max = Math.max(max, current);
        }

        return max;
    }
}
