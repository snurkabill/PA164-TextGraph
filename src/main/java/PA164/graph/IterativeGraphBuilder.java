package PA164.graph;

import PA164.data.Sentence;

import java.util.ArrayList;
import java.util.List;

public class IterativeGraphBuilder {

    public Graph run(List<Sentence> sentenceList) {
        List<List<String>> wordMatrix = mergeSentences(sentenceList);
        int maximumLength = getLongestSentence(wordMatrix);
        int allWords = wordMatrix.stream().mapToInt(List::size).sum();
        int batchWords = 0;
        Graph textGraph = new Graph();
        for (int i = 0; i < maximumLength * wordMatrix.size() || batchWords != allWords; i++) {
            List<String> batch = createBatchOfWords(i, wordMatrix);
            batchWords += batch.size();
            if(textGraph.tryAddNewBatchofWords(batch)) {
                textGraph.generateNewEdges();
            }
        }
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

    private List<List<String>> mergeSentences(List<Sentence> sentenceList) {
        List<List<String>> words = new ArrayList<>();
        for (Sentence sentence : sentenceList) {
            words.add(sentence.getCleanedWordList());
        }
        return words;
    }
}
