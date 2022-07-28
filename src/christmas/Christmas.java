package christmas;

import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Christmas {
    @Test
    public void main() {
        In.open("src/christmas/public/test2.in");
        Out.compareTo("src/christmas/public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static boolean dfs(ArrayList<Integer>[] graph, int u, boolean[] visited, boolean[] color) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) {
                color[v] = !color[u];
                if (!dfs(graph, v, visited, color)) {
                    return false;
                }
            } else if (color[u] == color[v]) {
                return false;
            }
        }

        return true;
    }

    private static void testCase() {
        // bipartite <=> no cycle of odd length
        int n = In.readInt();
        int m = In.readInt();
        var graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<Integer>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();

            start = u;
            graph[u].add(v);
            graph[v].add(u);
        }

        var color = new boolean[n];
        var visited = new boolean[n];
        boolean isBipartite = dfs(graph, start, visited, color);

        Out.println(isBipartite ? "yes" : "no");
    }
}
