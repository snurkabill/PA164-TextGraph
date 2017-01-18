package PA164.utils.importance;

import PA164.graph.Vertex;

import java.util.List;
import java.util.Set;

public interface ImportanceCalculator {

    double calcImportance(Set<Vertex> verticesSet, List<String> words);

}
