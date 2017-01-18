package PA164.utils;

import PA164.data.DataFile;
import PA164.data.Sentence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextSampleReader {

    private List<DataFile> dataFileList = new ArrayList<>();

    public void readFiles(String path) throws IOException {
        Stream<Path> paths = Files.walk(Paths.get(path));
        paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        List<Sentence> sentences = Files
                                .readAllLines(filePath)
                                .stream()
                                .map(Sentence::new)
                                .collect(
                                        Collectors
                                                .toList()
                                );
                        dataFileList.add(new DataFile(sentences));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            }
        );
    }

    public List<DataFile> getAllFiles() {
        return dataFileList;
    }

}
