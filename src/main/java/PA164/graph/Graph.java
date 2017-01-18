package PA164.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private Set<Vertex> vertices = new HashSet<>();

    public boolean tryAddNewBatchofWords(List<String> batch) {
        boolean wasAddedAtLeastsOne = false;
        for (String s : batch) {
            if(tryAddNewWord(s)) {
                wasAddedAtLeastsOne = true;
            }
        }
        return wasAddedAtLeastsOne;
    }

    public boolean tryAddNewWord(String word) {
        Vertex vertex = new Vertex(word);
        return vertices.add(vertex);
    }

    public void generateNewEdges() {
        Random random = new Random();
        for (Vertex vertex : vertices) {
            Set<Vertex> verticesOfSelectedVertex = vertex.getVertices();
            List<Vertex> filteredVertices = vertices
                    .stream()
                    .filter(vertex1 -> !verticesOfSelectedVertex.contains(vertex1))
                    .filter(vertex1 -> !vertex1.getWord().equals(vertex.getWord()))
                    .collect(Collectors.toList());
            if(filteredVertices.size() == 0) {
                return;
            }
            if(!vertex.addVertex(filteredVertices.get(random.nextInt(filteredVertices.size())))) {
                throw new IllegalArgumentException("The vertex was not added");
            }
        }
    }

    public void performRandomWalk(int lengthOfWalk) {
        Vertex vertex = getStartingVertex();
        for (int i = 0; i < lengthOfWalk; i++) {
            vertex = vertex.visitVertex(new Random());
        }
    }

    private Vertex getStartingVertex() {
        Random random = new Random();
        int startingVertexIndex = random.nextInt(vertices.size());
        int iteratedIndex = 0;
        for (Vertex vertex : vertices) {
            if(iteratedIndex == startingVertexIndex) {
                return vertex;
            }
        }
        throw new IllegalStateException("No vertex was picked for start");
    }
}
