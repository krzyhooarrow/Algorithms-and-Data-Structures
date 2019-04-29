import Algorithms.Dijkstra;
import Models.Edge;
import Models.Graph;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Zadanie2 {

    public static void main(String[] args) {
        Random generator = new Random();

        long start = System.currentTimeMillis();
        int vertexSize = 6;
        int edgesSize = 1000000;
        Graph graph = new Graph(vertexSize);

        Collections.addAll(graph.getEdges()

                , new Models.Edge(0, 3, 0)
                , new Models.Edge(3, 0, 0)

                , new Models.Edge(0, 1, 9)
                , new Models.Edge(1, 0, 9)

                , new Models.Edge(1, 2, 6)
                , new Models.Edge(2, 1, 6)

                , new Models.Edge(2, 3, 11)
                , new Models.Edge(3, 2, 11)

                , new Models.Edge(0, 4, 14)
                , new Models.Edge(4, 0, 14)

                , new Models.Edge(2, 5, 15)
                , new Models.Edge(5, 2, 15)

                , new Models.Edge(3, 4, 9)
                , new Models.Edge(4, 3, 9)

                , new Models.Edge(3, 5, 10)
                , new Models.Edge(5, 3, 10)

                , new Models.Edge(4, 5, 7)
                , new Models.Edge(5, 4, 7)

                // 18
                    // 3 to f
                //13 14
//                , new Models.Edge(0, 2, 3)
//                , new Models.Edge(1, 2, 5)
//                , new Models.Edge(3, 4, 3)
//                , new Models.Edge(4, 2, 5)
//                , new Models.Edge(2, 3, 2)
//                , new Models.Edge(3, 4, 3)
//                ,new Models.Edge(2,3,3)
//                ,new Models.Edge(5,3,1)
//                ,new Models.Edge(3,1,3)

        );
//      //Dijksta E + V log V   kruksla ma E log V
//        for (int i = 0; i < edgesSize; i++)
//            graph.getEdges().add(new Edge(generator.nextInt(vertexSize), generator.nextInt(vertexSize), generator.nextInt(500) + 1));
        graph.calculateAdjacencyListUndirected();

        Dijkstra.getAlgorithm().shortestPath(0, graph);

        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));


    }
}






