package graph;

public class UnweightedGraph<V> extends WeightedGraph<V> {
    public UnweightedGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(V src, V dst) {
        super.addEdge(src, dst, 1.0);
    }
}
