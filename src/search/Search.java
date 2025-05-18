package search;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected final Map<V, V> edgeTo;
    protected final V start;

    protected Search(Map<V, V> edgeTo, V start) {
        this.edgeTo = edgeTo;
        this.start  = start;
    }

    public boolean hasPathTo(V v) {
        return edgeTo.containsKey(v) || start.equals(v);
    }

    public List<V> pathTo(V v) {
        if (!hasPathTo(v)) return Collections.emptyList();

        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
            if (x.equals(start)) break;
        }
        return path;
    }
}
