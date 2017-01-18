package PA164;

import PA164.data.DataFile;
import PA164.data.Sentence;
import PA164.utils.DataFileEvaluator;
import PA164.utils.TextSampleReader;
import PA164.utils.importance.AverageImportanceCalculator;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        TextSampleReader textSampleReader = new TextSampleReader();
        textSampleReader.readFiles("c:\\Users\\Snurka\\Documents\\r_project\\BlogSum\\data\\");

        List<DataFile> dataFileList = textSampleReader.getAllFiles();

        DataFileEvaluator dataFileEvaluator = new DataFileEvaluator();
        dataFileEvaluator.evaluateDataFile(dataFileList.get(0), new AverageImportanceCalculator(), 1000000, 100);

        dataFileList.get(0).getMostImportantSentences(5).stream().map(Sentence::getOriginal).forEach(System.out::println);

        System.out.println("hello");
    }
}
