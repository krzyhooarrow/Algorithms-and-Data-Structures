
import Algorithms.Kosaraju;
import Models.Graph;

import java.util.Collections;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class Zadanie4 {

    public static void main(String[] args) {


        Random generator = new Random();
        int vertexSize = 5;
        int edgesSize = 40;
        Graph graph = new Graph(vertexSize);
//
        int k;
        int l;
//        for (int i = 0; i < edgesSize; i++) {
//            k = generator.nextInt(vertexSize);
//            l = generator.nextInt(vertexSize);
//            if (k != l )
//                graph.getEdges().add(new Edge(k, l, generator.nextInt(500) + 1));
//        }
//            graph.calculateAdjacencyListUndirected();

//        DSFstack.getAlgorithm().walk(graph,0);

//
//
//        Tarjan.getAlgorithm().calculate(graph);

        Kosaraju g = new Kosaraju(graph);

        Collections.addAll(graph.getEdges()
                ,new Models.Edge(2,1,1)
                ,new Models.Edge(0,2,1)
                ,new Models.Edge(1,0,1)
                ,new Models.Edge(0,3,1)
                ,new Models.Edge(3,4,3)


        );

//        g.addEdge(2, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 0);
//        g.addEdge(0, 3);
//        g.addEdge(3, 4);

        graph.calculateAdjacencyListUndirected();
//        g.addEdge(0, 2);
//        g.addEdge(3, 0);
//        g.addEdge(5, 0);
//        g.addEdge(4, 1);
//        g.addEdge(3, 1);
//        g.addEdge(1, 2);
//        g.addEdge(4, 2);
//        g.addEdge(3, 4);
//        g.addEdge(5, 4);
        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.printSCCs();

    }



}
