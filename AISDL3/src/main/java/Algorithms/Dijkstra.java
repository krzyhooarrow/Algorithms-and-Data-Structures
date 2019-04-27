package Algorithms;

import Models.Edge;
import Models.Element;
import Models.Graph;
import Structures.PriorityQueque;

@SuppressWarnings("Duplicates")
public class Dijkstra {
    private static Dijkstra dijkstra = new Dijkstra();

    private Dijkstra() {
    }

    public static Dijkstra getAlgorithm() {
        return dijkstra;
    }

    private int maxValue = 10000;
    private int[] d;
    private int[] p;


    public void shortestPath(int source, Graph graph) {
        if (source <= graph.verticles) {
            PriorityQueque priorityQueque = new PriorityQueque(Element.class);

            d = new int[graph.verticles];
            p = new int[graph.verticles];

            for (int i = 0; i < graph.verticles; i++)   // odległosci od wierzchołków na max.wartosc
                d[i] = maxValue;
            d[source] = 0;

            for (int i = 0; i < graph.verticles; i++) { // dodanie wszystkich wierzchołków wraz z ich odleglosciami do kolejki
                p[i] = -1;
                priorityQueque.insert(new Element(i, d[i]));
            }


            Element e;

            while (!priorityQueque.isEmpty()) {
                e = (Element) priorityQueque.pop();
                for (Edge edge : graph.getAdjacencyLists().get(e.getValue())
                ) {
                    if (d[edge.getNext()] > d[edge.getPrevious()] + edge.getWeight()) {
                        d[edge.getNext()] = d[edge.getPrevious()] + edge.getWeight();
                        p[edge.getNext()] = edge.getPrevious();
                    }
                }

            }


            print();
        }

    }

    private int[] distances() {
        return d;
    }

    private int[] previous() {
        return p;
    }

    private void print() {

        System.out.print("[N]: ");
        for (int i = 0; i < d.length; i++)
            System.out.print(i + " ");

        System.out.println();

        System.out.print("[d]: ");
        for (int i = 0; i < d.length; i++)
            System.out.print(d[i] + " ");

        System.out.println();
        System.out.print("[p]: ");
        for (int i = 0; i < d.length; i++)
            System.out.print(p[i] + " ");

        System.out.println();

    }

}
