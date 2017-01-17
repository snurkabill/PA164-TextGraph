package PA164.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterativeGraphBuilder {

    public Graph<String> run(List<String> allSentences) {
        List<List<String>> wordMatrix = splitToWords(allSentences);
        int maximumLength = getLongestSentence(wordMatrix);
        int allWords = wordMatrix.stream().mapToInt(List::size).sum();
        int batchWords = 0;
        for (int i = 0; i < maximumLength * wordMatrix.size() || batchWords != allWords; i++) {
            List<String> batch = createBatchOfWords(i, wordMatrix);
            batchWords += batch.size();
        }
        GraphImpl<String> textGraph = new GraphImpl<>();
        return textGraph;
    }

    private List<String> createBatchOfWords(int index, List<List<String>> wordMatrix) {
        List<String> batch = new ArrayList<>();
        for (int i = index; i >= 0; i--) {
            int x = index - i;
            int y = i;

            if(wordMatrix.size() > y) {
                if(wordMatrix.get(y).size() > x) {
                    batch.add(wordMatrix.get(y).get(x));
                }
            }
        }
        return batch;
    }

    private int getLongestSentence(List<List<String>> wordMatrix) {
        int max = 0;
        for (List<String> sentence : wordMatrix) {
            if (sentence.size() > max) {
                max = sentence.size();
            }
        }
        return max;
    }

    private List<List<String>> splitToWords(List<String> allSentences) {
        List<List<String>> wordMatrix = new ArrayList<>();
        for (String sentence : allSentences) {
            wordMatrix.add(Arrays.asList(sentence.split(" ")));
        }
        return wordMatrix;
    }
}
