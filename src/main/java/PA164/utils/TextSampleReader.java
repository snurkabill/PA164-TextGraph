package PA164.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TextSampleReader {

    private List<List<String>> sentences = new ArrayList<>();

    public void readFiles(String path) throws IOException {
        Stream<Path> paths = Files.walk(Paths.get(path));
        paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        sentences.add(Files.readAllLines(filePath));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            }
        );
    }

    public List<List<String>> getAllFileContent() {
        return sentences;
    }

    public List<String> getFileContentInSentences(int index) {
        return sentences.get(index);
    }

}
