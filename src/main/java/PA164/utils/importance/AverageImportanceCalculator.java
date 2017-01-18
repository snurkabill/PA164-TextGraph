package PA164.utils.importance;


import PA164.graph.Vertex;

import java.util.List;
import java.util.Set;

public class AverageImportanceCalculator implements ImportanceCalculator {

    @Override
    public double calcImportance(Set<Vertex> verticesSet, List<String> words) {
        int totalCount = 0;
        for (String word : words) {
            for (Vertex vertex : verticesSet) {
                if(vertex.getWord().equals(word)) {
                    totalCount += vertex.getVisitsCount();
                }
            }
        }
        return totalCount/words.size();
    }
}
