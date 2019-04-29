
import Algorithms.Kosaraju;
import Models.Edge;
import Models.Graph;

import java.util.Collections;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class Zadanie4 {

    public static void main(String[] args) {


        Random generator = new Random();
        int vertexSize = 8;
        int edgesSize = 10000;
        Graph graph = new Graph(vertexSize);

        int k;
        int l;
//        for (int i = 0; i < edgesSize; i++) {
//            k = generator.nextInt(vertexSize);
//            l = generator.nextInt(vertexSize);
//            if (k != l )
//                graph.getEdges().add(new Edge(k, l, generator.nextInt(500) + 1));
//        }


        Kosaraju g = new Kosaraju(graph);

        Collections.addAll(graph.getEdges()
                ,new Models.Edge(0,1,1)
                ,new Models.Edge(2,0,2)
                ,new Models.Edge(2,3,2)
                ,new Models.Edge(1,3,2)
                ,new Models.Edge(3,6,2)
                ,new Models.Edge(6,3,2)
                ,new Models.Edge(4,6,2)
                ,new Models.Edge(5,7,2)
                ,new Models.Edge(7,7,2)
                ,new Models.Edge(6,7,2)
                ,new Models.Edge(4,5,2)
                ,new Models.Edge(5,4,2)
                ,new Models.Edge(1,2,2)
//                ,new Models.Edge(3,7,14)
                //c to 2 d to 3 g to 6


//                ,new Models.Edge(0,2,1)
//                ,new Models.Edge(1,0,1)
//                ,new Models.Edge(0,3,1)
//                ,new Models.Edge(3,4,3)


        );
//        System.out.println(graph.getEdges());
        graph.calculateAdjacencyListUndirected();

        System.out.println("Spójne składowe  :");
        g.printSCCs();

    }



}
