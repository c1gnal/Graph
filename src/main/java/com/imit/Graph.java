package com.imit;

import java.util.*;

public class Graph {
    private Map<Integer,List<Integer>> adjacencyList = null;

    public Graph() {
        this.adjacencyList = new TreeMap<Integer, List<Integer>>();
    }

    public boolean addVertex(int vertexNumber) {
        if(!this.adjacencyList.containsKey(vertexNumber)) {
            return false;
        }
        else {
            this.adjacencyList.put(vertexNumber, new ArrayList<Integer>());
            return true;
        }
    }

    public void addVertex() {
        int size = this.adjacencyList.size();
        this.adjacencyList.put(size, new ArrayList<Integer>());
    }

    public boolean delEdgesOfVertex(int vertexNumber) {
        if(!this.adjacencyList.containsKey(vertexNumber)) {
            return false;
        }
        else {
            System.out.println(this.adjacencyList.get(vertexNumber).size());
            this.adjacencyList.get(vertexNumber).clear();
            System.out.println(this.adjacencyList.get(vertexNumber).size());
            return true;
        }
    }
    public boolean addEdgesToVertex(int vertexNumber,List<Integer> vertexsOfEdges) {
        if(this.adjacencyList.get(vertexNumber) == null || !this.adjacencyList.containsKey(vertexNumber)) {
            return false;
        }
        else {
            this.adjacencyList.get(vertexNumber).addAll(vertexsOfEdges);
            return true;
        }
    }
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(Integer v: this.adjacencyList.keySet()) {
            output.append("v " + v + " -> ");
            for(Integer ev:this.adjacencyList.get(v)) {
                output.append(ev).append(" -> ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<Integer, List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
