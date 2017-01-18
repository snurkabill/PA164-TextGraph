package PA164.data;

import java.util.Arrays;
import java.util.List;

public class Sentence {

    private final String original;
    private final List<String> cleanedWordList;
    private double importance = 0.0;

    public Sentence(String sentence) {
        this.original = sentence;
        cleanedWordList = Arrays.asList(
                sentence
                        .replace(")", "")
                        .replace("(", "")
                        .replace(",", "")
                        .replace(".", "")
                        .replace("-", "")
                        .split(" "));
    }

    public List<String> getCleanedWordList() {
        return cleanedWordList;
    }

    public String getOriginal() {
        return original;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }

    public double getImportance() {
        return importance;
    }
}
