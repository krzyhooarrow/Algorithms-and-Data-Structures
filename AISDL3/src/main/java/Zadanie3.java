import Algorithms.Borµwka;
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
        int vertexSize = 9;
//        int edgesSize = 10000;
        Graph graph = new Graph(vertexSize);
//
        Collections.addAll(graph.getEdges()
                ,new Models.Edge(0,1,4)
                ,new Models.Edge(1,2,8)
                ,new Models.Edge(2,3,7)
                ,new Models.Edge(3,4,9)
                ,new Models.Edge(4,5,10)
                ,new Models.Edge(5,6,2)
                ,new Models.Edge(6,7,1)
                ,new Models.Edge(7,0,-2)


                ,new Models.Edge(1,7,11)


                ,new Models.Edge(2,8,0)
                ,new Models.Edge(7,8,7)

                ,new Models.Edge(6,8,6)

                ,new Models.Edge(2,5,4)

        );

        long start = System.currentTimeMillis();
        int k;
        int l;
//        for (int i = 0; i < edgesSize ; i++) {
//            k = generator.nextInt(vertexSize);
//            l = generator.nextInt(vertexSize);
//            if (k!=l  )
//            graph.getEdges().add(new Edge(k,l, generator.nextInt(500) + 1));
//        }
         graph.calculateAdjacencyListUndirected();
        System.out.println("\nkruskal");
        Kruskal(graph);
        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));


        start = System.currentTimeMillis();
        System.out.println("\nprime");
        Prime(graph,0);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
        System.out.println();
        start = System.currentTimeMillis();

        System.out.println("borówka");
        Borµwka borµwka = new Borµwka(graph);
        borµwka.find();
        System.out.println("Time: " + (System.currentTimeMillis() - start));

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
