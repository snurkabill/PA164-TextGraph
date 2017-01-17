package PA164.graph;

import PA164.utils.Tuple;

import java.util.Collection;
import java.util.TreeSet;

public class GraphImpl<T extends Comparable<T>> implements Graph<T> {

    private TreeSet<T> vertexSet;
    private TreeSet<Tuple<T>> edgeSet;

    public void addVertex(T vertex) {
        vertexSet.add(vertex);
    }

    public void addEdge(Tuple<T> edge) {
        edgeSet.add(edge);
    }

    public void removeEdge(Tuple<T> edge) {
        edgeSet.remove(edge);
    }

    public void removeVertex(T vertex) {
        vertexSet.remove(vertex);
    }

    public Collection<T> getVerticeCollection() {
        return vertexSet;
    }

    public Collection<Tuple<T>> getEdgeCollection() {
        return edgeSet;
    }
}
