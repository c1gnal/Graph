package com.imit;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Pretty_Visitor on 10.01.2015.
 */
public class Main {
    public static void main(String[]args) throws IOException {

        ObjectMapper om = new ObjectMapper();
        Map<Integer,List<Integer>> list =  om.readValue(new File("D:\\GitHub\\graph\\Graph\\src\\main\\resources/graph.json"), new TypeReference<Map<Integer,List<Integer>>>(){});
                Graph graph =  new Graph(list);
        GavrilAndYannakakisAlgorithm ga = new GavrilAndYannakakisAlgorithm();
        System.out.println(ga.solve(graph,true));
    }
}
