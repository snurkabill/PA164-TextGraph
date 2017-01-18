package PA164;

import PA164.data.DataFile;
import PA164.data.Sentence;
import PA164.utils.DataFileEvaluator;
import PA164.utils.TextSamplePrinter;
import PA164.utils.TextSampleReader;
import PA164.utils.importance.AverageImportanceCalculator;

import java.io.IOException;
import java.util.List;

public class App {

    public static final String DATA_PATH = "BlogSum\\data\\";

    public static void main(String[] args) throws IOException {
        String masterPath = args[0];
        String pathToFile = masterPath + DATA_PATH;
        int lengthOfRandomWalk = Integer.parseInt(args[1]);
        int numberOfIterationsPerFile = Integer.parseInt(args[2]);
        int numberOfMostImportantSentences = Integer.parseInt(args[3]);

        TextSampleReader textSampleReader = new TextSampleReader();
        textSampleReader.readFiles(pathToFile);
        List<DataFile> dataFileList = textSampleReader.getAllFiles();
        DataFileEvaluator dataFileEvaluator = new DataFileEvaluator();
        for (int i = 0; i < dataFileList.size(); i++) {
            dataFileList.get(i).getSentenceList().sort((o1, o2) -> o1.getCleanedWordList().size() == o2.getCleanedWordList().size() ? 0 : o1.getCleanedWordList().size() < o2.getCleanedWordList().size() ? 1 : -1);
            dataFileEvaluator.evaluateDataFile(dataFileList.get(i), new AverageImportanceCalculator(), lengthOfRandomWalk, numberOfIterationsPerFile);
            List<Sentence> mostImportant = dataFileList.get(i).getMostImportantSentences(numberOfMostImportantSentences);
            TextSamplePrinter.printSentences(i, mostImportant, masterPath);
        }
    }
}
