package Algorithms;

import Models.Edge;
import Models.Graph;
import Structures.PriorityQueque;

import java.util.*;
    // Prime dobry tylko kolejka dalej zbugowana
@SuppressWarnings("Duplicates")
public class Prime {
    private UnionFind unionFind = new UnionFind();
    private ArrayList<Edge> T = new ArrayList<>();  // przechowywane krawedzie
    private HashSet hashSet = new HashSet();

    public void calculate(Graph graph, int source) {

        if (source <= graph.verticles) {

            PriorityQueque priorityQueque = new PriorityQueque(Edge.class);

            int[] d = new int[graph.verticles];
            int[] p = new int[graph.verticles];

            for (Edge e : graph.getAdjacencyLists().get(source)
            ) {
                priorityQueque.insert(e);         // w kolejce sa wszystkie krawedzie zrodla
            }


            for (int i = 0; i < graph.verticles; i++) {
                unionFind.getSetsList().add(unionFind.MakeSet(i));
                d[i] = 10000;
                p[i] = -1;

            }
            d[source] = 0;

            Edge e;

            while (!priorityQueque.isEmpty() && !check(graph)) {

                e = (Edge) priorityQueque.pop();
                if (unionFind.find(source) != unionFind.find(e.getPrevious())) {
                    unionFind.union(unionFind.find(source), unionFind.find(e.getPrevious()));
                    for (Edge k : graph.getAdjacencyLists().get(e.getPrevious())
                    ) {
                        priorityQueque.insert(k);

                    }
                    T.add(e);
                }
                else if (unionFind.find(source) != unionFind.find(e.getNext())) {
                    unionFind.union(unionFind.find(source), unionFind.find(e.getNext()));
                    for (Edge k : graph.getAdjacencyLists().get(e.getNext())
                    ) {
                        priorityQueque.insert(k);


                    }
                    T.add(e);
                }
            }

        }

    }


    public int getMinWeight(Graph graph) {
        if( check(graph)) {
            int i = 0;
            for (Edge e : T
            ) {
                i += e.getWeight();

            }
            return i;
        }
        return 0;
    }

    private boolean check(Graph graph) {
      if (unionFind.find(0).size()!=graph.getVerticles())
        return false;

        return true;
    }

    public ArrayList<Edge> getT() {
        return T;
    }
}

