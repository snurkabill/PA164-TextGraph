package PA164.graph;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Vertex {

    private Set<Vertex> vertices = new HashSet<>();
    private String word;
    private int visitsCount;

    public Vertex(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getVisitsCount() {
        return visitsCount;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public boolean addVertex(Vertex vertex) {
       return vertices.add(vertex);
    }

//    private boolean canBeAdded(Vertex vertex) {
//        if(word.equals(vertex.getWord())) {
//            return false;
//        }
//        for (Vertex iteratedVertex : vertices) {
//            if(iteratedVertex.getWord().equals(vertex.getWord())) {
//                return false;
//            }
//        }
//        return true;
//    }

    public Vertex visitVertex(Random random) {
        visitsCount++;
        int startingVertexIndex = random.nextInt(vertices.size());
        int iteratedIndex = 0;
        for (Vertex vertex : vertices) {
            if(iteratedIndex == startingVertexIndex) {
                return vertex;
            }
            iteratedIndex++;
        }
        throw new IllegalStateException("No vertex was picked");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return getWord().equals(vertex.getWord());
    }

    @Override
    public int hashCode() {
        return getWord().hashCode();
    }
}
