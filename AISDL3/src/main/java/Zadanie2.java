import Algorithms.Dijkstra;
import Models.Edge;
import Models.Graph;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Zadanie2 {

    public static void main(String[] args) {
        Random generator = new Random();

        long start = System.currentTimeMillis();
        int vertexSize = 10000;
        int edgesSize = 1000000 ;
        Graph graph = new Graph(vertexSize);

        Collections.addAll(graph.getEdges()
                ,new Models.Edge(1,2,1)
                ,new Models.Edge(0,2,1)
                ,new Models.Edge(2,5,1)
                ,new Models.Edge(5,0,6)
                ,new Models.Edge(0,4,3)
                ,new Models.Edge(4,5,2)
                ,new Models.Edge(2,3,3)
                ,new Models.Edge(5,3,1)
                ,new Models.Edge(3,1,3)

        );

        for (int i = 0; i < edgesSize; i++)
            graph.getEdges().add(new Edge(generator.nextInt(vertexSize), generator.nextInt(vertexSize), generator.nextInt(500) + 1));
       graph.calculateAdjacencyListDirected();

        Dijkstra.getAlgorithm().shortestPath(0, graph);

        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));


    }
}






