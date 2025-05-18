package search;
import graph.Vertex;
import graph.WeightedGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distTo = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(new HashMap<>(), start);
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<V> graph, V startKey) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(distTo.get(a.getData()), distTo.get(b.getData()))
        );

        for (Vertex<V> v : graph.getVertices()) {
            double dist = v.getData().equals(startKey) ? 0.0 : Double.POSITIVE_INFINITY;
            distTo.put(v.getData(), dist);
        }
        edgeTo.put(startKey, null);
        pq.add(graph.getVertex(startKey));

        while (!pq.isEmpty()) {
            Vertex<V> curr = pq.poll();
            double currDist = distTo.get(curr.getData());

            for (Map.Entry<Vertex<V>, Double> entry : curr.getAdjacent().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight        = entry.getValue();
                double newDist = currDist + weight;

                if (newDist < distTo.get(neighbor.getData())) {
                    distTo.put(neighbor.getData(), newDist);
                    edgeTo.put(neighbor.getData(), curr.getData());
                    pq.remove(neighbor);         // update priority
                    pq.add(neighbor);
                }
            }
        }
    }
    public double distanceTo(V v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}