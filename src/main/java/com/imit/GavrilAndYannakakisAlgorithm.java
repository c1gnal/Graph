package com.imit;

import java.util.ArrayList;
import java.util.List;

/**
 * This algorithm was developed by Fanica Gavril and Mihalis Yannakakis in 1974. It solve the Vertex Cover problem.
 */
public class GavrilAndYannakakisAlgorithm {

    public  List<Integer> solve(Graph graph, boolean isRandom) {
        List<Integer> cover = new ArrayList<>();
        while(graph.hasEdges()) {
            int firstVertex = getVertexWithEdges(graph, isRandom);
            int secondVertex = getVertexOfEdge(graph.getVertexesOfEdges(firstVertex),isRandom);
            graph.delEdgesOfVertex(firstVertex);
            graph.delEdgesOfVertex(secondVertex);
            if(graph.hasEdges()) {
                cover.add(firstVertex);
                cover.add(secondVertex);
            }
        }
        return cover;
    }

    private int getVertexOfEdge(List<Integer> vertexes,boolean isRandom) {
        if(!isRandom) {
           return vertexes.get(0);
        }
        else {
                return vertexes.get(((int)(Math.random()*vertexes.size())));
        }
    }

    private int getVertexWithEdges(Graph graph, boolean isRandom) {
        if(graph == null) {
            throw new NullPointerException("graph is null");
        }
        if(!graph.hasEdges()) {
            return -1;
        }
        if(!isRandom) {
            for(int i = 1; i <= graph.getVertexesCount(); i++) {
                Integer elem = graph.getVertex(i);
                if(elem != null && !graph.getAdjacencyList().get(elem).isEmpty()) {
                    return elem;
                }
            }
        }
        else {
            while(true) {
                Integer currentVertex = graph.getVertex((int)(Math.random()*graph.getVertexesCount() + 1));
                if(currentVertex != null && !graph.getVertexesOfEdges(currentVertex).isEmpty()) {
                    return currentVertex;
                }
            }
        }
        return -1;
    }
}
