package search;
import graph.UnweightedGraph;
import graph.Vertex;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(UnweightedGraph<V> graph, V start) {
        super(new HashMap<>(), start);
        edgeTo.put(start, null);
        dfs(graph, start);
    }

    private void dfs(UnweightedGraph<V> graph, V currentKey) {
        Vertex<V> curr = graph.getVertex(currentKey);
        if (curr == null) return;

        for (Vertex<V> neighbor : curr.getAdjacent().keySet()) {
            V nKey = neighbor.getData();
            if (!edgeTo.containsKey(nKey)) {
                edgeTo.put(nKey, currentKey);
                dfs(graph, nKey);
            }
        }
    }
}