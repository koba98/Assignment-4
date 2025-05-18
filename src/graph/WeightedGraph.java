package graph;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final boolean directed;
    private final Map<V, Vertex<V>> vertices = new HashMap<>();

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(V src, V dst, double weight) {
        Vertex<V> vSrc = vertices.computeIfAbsent(src, Vertex::new);
        Vertex<V> vDst = vertices.computeIfAbsent(dst, Vertex::new);

        vSrc.addAdjacentVertex(vDst, weight);
        if (!directed) {
            vDst.addAdjacentVertex(vSrc, weight);
        }
    }

    public Vertex<V> getVertex(V key) {
        return vertices.get(key);
    }

    public Iterable<Vertex<V>> getVertices() {
        return vertices.values();
    }

    public boolean isDirected() {
        return directed;
    }
}
