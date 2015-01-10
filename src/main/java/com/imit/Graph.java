package com.imit;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.io.Serializable;
import java.util.*;

public class Graph implements Serializable{
    public Graph(Map<Integer, List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    @JsonDeserialize(as=LinkedHashMap.class,keyAs = Integer.class,contentAs=ArrayList.class)
    private Map<Integer,List<Integer>> adjacencyList = null;

    public boolean isEmpty() {
        return false;
    }
    public boolean hasEdges(){
        if(this.isEmpty()) {
            return false;
        }
        for(List<Integer> list:this.adjacencyList.values()) {
            if(!list.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> getVertexesOfEdges(int vertexNumber) {
        return this.adjacencyList.get(vertexNumber);
    }
    public int getVertexesCount() {
        return this.adjacencyList.size();
    }
    public Graph() {
        this.adjacencyList = new TreeMap<Integer, List<Integer>>();
    }
    public Integer getVertex(int vertexNumber) {
        if(this.adjacencyList.containsKey(vertexNumber)) {
            return vertexNumber;
        }
        return null;
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
        } else {
            this.adjacencyList.get(vertexNumber).clear();
            for(List<Integer> list: this.adjacencyList.values()) {
                if(list.isEmpty()) {
                    continue;
                }
                for(int i = 0; i < list.size();i++) {
                    if(list.get(i) == vertexNumber) {
                        list.remove(i);
                    }
                }
            }
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
