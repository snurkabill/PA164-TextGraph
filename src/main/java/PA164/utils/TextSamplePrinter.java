package PA164.utils;


import PA164.data.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class TextSamplePrinter {

    public static void printSentences(int index, List<Sentence> sentenceList, String path) throws FileNotFoundException {
        String alternatedPath = path + "/sum2/";
        new File(alternatedPath).mkdir();
        try(PrintWriter printWriter = new PrintWriter(alternatedPath + "task" + (index + 1) + "_englishSyssum1.txt")) {
            for (Sentence sentence : sentenceList) {
                printWriter.println(sentence.getOriginal());
            }
        }
    }
}
