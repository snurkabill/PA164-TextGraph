package PA164.graph;

import PA164.utils.Tuple;

import java.util.Collection;

public interface Graph<T extends Comparable<T>> {

    void addVertex(T vertex);

    void addEdge(Tuple<T> edge);

    void removeEdge(Tuple<T> edge);

    void removeVertex(T vertex);

    Collection<T> getVerticeCollection();

    Collection<Tuple<T>> getEdgeCollection();

}
