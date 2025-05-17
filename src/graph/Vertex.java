package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacent = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacent.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getAdjacent() {
        return adjacent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

