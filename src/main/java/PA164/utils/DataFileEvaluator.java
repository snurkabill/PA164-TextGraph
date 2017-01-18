package PA164.utils;

import PA164.data.DataFile;
import PA164.data.Sentence;
import PA164.graph.Graph;
import PA164.graph.IterativeGraphBuilder;
import PA164.graph.Vertex;
import PA164.utils.importance.ImportanceCalculator;

import java.util.List;
import java.util.Set;

public class DataFileEvaluator {

    public void evaluateDataFile(DataFile dataFile, ImportanceCalculator importanceCalculator, int lengthOfRandomWalk, int numberOfIterations) {
        List<Sentence> sentenceList = dataFile.getSentenceList();
        for (int i = 0; i < numberOfIterations; i++) {
            IterativeGraphBuilder iterativeGraphBuilder = new IterativeGraphBuilder();
            Graph graph = iterativeGraphBuilder.run(dataFile.getSentenceList());
            graph.performRandomWalk(lengthOfRandomWalk);
            Set<Vertex> vertices = graph.getVertices();
            for (Sentence sentence : sentenceList) {
                double importance = sentence.getImportance();
                sentence.setImportance(importance + importanceCalculator.calcImportance(vertices, sentence.getCleanedWordList()));
            }
            System.out.println(i);
        }
        for (Sentence sentence : sentenceList) {
            sentence.setImportance(sentence.getImportance()/numberOfIterations);
        }
        sentenceList.sort((o1, o2) -> o1.getImportance() == o2.getImportance() ? 0 : o1.getImportance() > o2.getImportance() ? 1 : -1);
    }

    private void printWords(List<Vertex> list) {
        list.sort((o1, o2) -> o1.getVisitsCount() == o2.getVisitsCount() ? 0 : o1.getVisitsCount() > o2.getVisitsCount() ? 1 : -1 );
        for (Vertex vertex : list) {
            System.out.println(vertex.getVisitsCount() + "\t" + vertex.getWord());
        }
    }
}
