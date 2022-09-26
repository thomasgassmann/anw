package hourglass;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class Hourglass {
    @Test
    public void main() {
        In.open("src/hourglass/public/test1.in");
        Out.compareTo("src/hourglass/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static boolean color(boolean[] c, boolean[] visited, LinkedList<Integer>[] edges, int start) {
        visited[start] = true;
        for (var edge : edges[start]) {
            if (visited[edge] && c[start] == c[edge]) {
                return false;
            }

            if (!visited[edge]) {
                c[edge] = !c[start];
                if (!color(c, visited, edges, edge)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        LinkedList<Integer>[] graphEdges = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graphEdges[i] = new LinkedList<Integer>();
        }


        var graph = new Graph(n + 2);
        int SOURCE = n;
        int SINK = n + 1;

        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = In.readInt();
        }

        var weights = new HashMap<Integer, HashMap<Integer, Integer>>();

        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();
            int w = In.readInt();
            graphEdges[u].add(v);
            graphEdges[v].add(u);

            if (!weights.containsKey(u)) {
                weights.put(u, new HashMap<Integer, Integer>());
            }

            if (!weights.containsKey(v)) {
                weights.put(v, new HashMap<Integer, Integer>());
            }

            weights.get(u).put(v, w);
            weights.get(v).put(u, w);

            graph.addEdge(u, v, w);
            graph.addEdge(v, u, w);
        }

        boolean[] c = new boolean[n];
        boolean[] visited = new boolean[n];
        if (!color(c, visited, graphEdges, 0)) {
            Out.println("no");
            return;
        }

        int totalSandLow = 0;
        int totalSandHigh = 0;
        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                graph.addEdge(i, SINK, s[i]);
                totalSandLow += s[i];
            } else {
                graph.addEdge(SOURCE, i, s[i]);
                totalSandHigh += s[i];
            }
        }

        var flow = graph.computeMaximumFlow(SOURCE, SINK);
        Out.println(flow >= Math.min(totalSandHigh, totalSandLow) ? "yes" : "no");
    }
}
