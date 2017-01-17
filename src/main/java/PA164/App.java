package PA164;

import PA164.graph.IterativeGraphBuilder;
import PA164.utils.TextSampleReader;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        TextSampleReader textSampleReader = new TextSampleReader();
        textSampleReader.readFiles("c:\\Users\\Snurka\\Documents\\r_project\\BlogSum\\data\\");
        IterativeGraphBuilder iterativeGraphBuilder = new IterativeGraphBuilder();
        iterativeGraphBuilder.run(textSampleReader.getAllFileContent().get(0));
        System.out.println("hello world");
    }

}
