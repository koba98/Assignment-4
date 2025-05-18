package search;
import graph.UnweightedGraph;
import graph.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(UnweightedGraph<V> graph, V start) {
        super(new HashMap<>(), start);
        bfs(graph, start);
    }
    private void bfs(UnweightedGraph<V> graph, V rootKey) {
        Queue<V> queue = new LinkedList<>();
        queue.add(rootKey);
        edgeTo.put(rootKey, null);
        while (!queue.isEmpty()) {
            V currentKey = queue.poll();
            Vertex<V> current = graph.getVertex(currentKey);
            if (current == null) continue;

            for (Vertex<V> neighbor : current.getAdjacent().keySet()) {
                V nKey = neighbor.getData();
                if (!edgeTo.containsKey(nKey)) {
                    edgeTo.put(nKey, currentKey);
                    queue.add(nKey);
                }
            }
        }
    }
}
