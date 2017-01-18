package PA164.data;

import java.util.ArrayList;
import java.util.List;

public class DataFile {

    private final List<Sentence> sentenceList;

    public DataFile(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public List<Sentence> getMostImportantSentences(int n) {
        sentenceList.sort((o1, o2) -> o1.getImportance() == o2.getImportance() ? 0 : o1.getImportance() < o2.getImportance() ? 1 : -1);
        List<Sentence> firstN = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            firstN.add(sentenceList.get(i));
        }
        return firstN;
    }
}
