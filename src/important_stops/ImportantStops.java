package important_stops;

import algorithms.Graph;
import io.In;
import io.Out;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class ImportantStops {
    @Test
    public void main() {
        In.open("src/important_stops/public/test1.in");
        Out.compareTo("src/important_stops/public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static int count = 0;

    private static void dfs(
            ArrayList<Integer>[] edges,
            int[] dfs,
            int[] low,
            int[] deg,
            boolean[] isArtVertex,
            int u) {
        dfs[u] = ++count;
        low[u] = dfs[u];

        for (var v : edges[u]) {
            if (dfs[v] == 0) {
                deg[u]++;
                dfs(edges, dfs, low, deg, isArtVertex, v);
                if (low[v] >= dfs[u] && dfs[u] != 1) {
                    isArtVertex[u] = true;
                }

                low[u] = Math.min(low[v], low[u]);
            } else {
                low[u] = Math.min(dfs[v], low[u]);
            }
        }
    }

    private static void testCase() {
        int n = In.readInt();
        int m = In.readInt();

        var edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();

            edges[u].add(v);
            edges[v].add(u);
        }

        int[] dfs = new int[n];
        int[] low = new int[n];
        int[] deg = new int[n];
        boolean[] isArtVertex = new boolean[n];
        // graph might not be connected
        var art = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (dfs[i] == 0) {
                count = 0;
                dfs(edges, dfs, low, deg, isArtVertex, i);
                if (deg[i] >= 2) {
                    isArtVertex[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isArtVertex[i] && edges[i].size() >= 2) {
                art.add(i);
            }
        }

        art.sort(Comparator.naturalOrder());
        if (art.size() == 0) {
            Out.println(-1);
            return;
        }

        for (int i = 0; i < art.size(); i++) {
            Out.print(art.get(i));
            Out.print(' ');
        }

        Out.println();
    }
}
