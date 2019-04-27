import Algorithms.Kruskal;
import Algorithms.Prime;
import Models.Edge;
import Models.Graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
@SuppressWarnings("Duplicates")
public class Zadanie3 {

    public static void main(String[] args) {
    // dla 10k i 100k t = 10s/41s i to trzeba skrocic

        Random generator = new Random();
        int vertexSize = 1000;
        int edgesSize = 10000;
        Graph graph = new Graph(vertexSize);
//
//        Collections.addAll(graph.getEdges()
//                ,new Models.Edge(0,1,31)
//                ,new Models.Edge(0,2,31)
//                ,new Models.Edge(0,3,31)
//                ,new Models.Edge(0,4,31)
//                ,new Models.Edge(4,0,12)
//                ,new Models.Edge(0,5,31)       // te 4 pokazuja ze nieskierowany
//                ,new Models.Edge(1,2,42)
//                ,new Models.Edge(2,5,51)
//                ,new Models.Edge(5,0,61)
//                ,new Models.Edge(0,4,27)
//                ,new Models.Edge(4,5,15)
//                ,new Models.Edge(2,3,22)
//                ,new Models.Edge(5,3,64)
//                ,new Models.Edge(3,1,34)
//
//        );

        long start = System.currentTimeMillis();
        int k;
        int l;
        for (int i = 0; i < edgesSize ; i++) {
            k = generator.nextInt(vertexSize);
            l = generator.nextInt(vertexSize);
            if (k!=l  )
            graph.getEdges().add(new Edge(k,l, generator.nextInt(500) + 1));
        }
         graph.calculateAdjacencyListUndirected();

        Kruskal(graph);
        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));
        System.out.println();
        start = System.currentTimeMillis();
        Prime(graph,0);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    public static void Kruskal(Graph graph){


    Kruskal kruskal = new Kruskal(graph);
    kruskal.find();
        for (Edge e:kruskal.getT()
        ) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("N =: " + kruskal.getT().size());
        System.out.println("W=: " + kruskal.getMinWeight());


    }


    public static void Prime(Graph graph, int source){


        Prime prime = new Prime();
        prime.calculate(graph,source);

        System.out.println();
        for (Edge e:prime.getT()
        ) {
            System.out.print(e + " ");

        }
        System.out.println();
        System.out.println("N =: " + prime.getT().size());
        System.out.println("W=: " + prime.getMinWeight(graph));

    }
}
